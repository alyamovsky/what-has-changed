package com.alyamovsky.whathaschanged.repository;

import com.alyamovsky.whathaschanged.entity.SteamApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface SteamAppRepository extends JpaRepository<SteamApp, UUID> {
    @Modifying
    @Query(value = """
            INSERT INTO steam_apps (app_id, name, updated_at)
            VALUES (:app_id, :name, null)
            ON CONFLICT (app_id)
            DO UPDATE
            SET name = EXCLUDED.name,
                updated_at = CASE
                                WHEN steam_apps.name IS DISTINCT FROM EXCLUDED.name THEN NOW()
                                ELSE steam_apps.updated_at
                             END
            WHERE steam_apps.name IS DISTINCT FROM EXCLUDED.name
            """, nativeQuery = true)
    void saveOrUpdate(@Param("app_id") Integer appId, @Param("name") String name);

    @Query("""
            SELECT app FROM steam_apps app WHERE app.name ILIKE CONCAT('%', :namePart, '%') ORDER BY app.appId
            """)
    List<SteamApp> findByNameContainingIgnoreCase(@Param("namePart") String namePart);
}
