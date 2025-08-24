package com.finboostplus.repository;

import com.finboostplus.model.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query(nativeQuery = true, value = """
            SELECT g.id ,g.created_at,g.description, g.name
                          FROM group_members gm
                          INNER JOIN groups g ON gm.group_id = g.id
                          INNER JOIN users ON gm.user_id = users.id
                          where users.id =:memberId
            """)
    Page<Group> listaGrupoUsuarioPage(Long memberId, Pageable pageable);

    // Group listGroupDetails(Long idGroup);
    // Group findByName(String name);
}
