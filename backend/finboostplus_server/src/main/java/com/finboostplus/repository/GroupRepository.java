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
            SELECT tb_g.id ,tb_g.created_at,tb_g.description, tb_g.name, tb_g.group_creator_id
                          FROM group_member gm
                          INNER JOIN tb_group tb_g ON gm.group_id = tb_g.id
                          INNER JOIN users ON gm.user_id = users.id
                          where users.id =:creatorId 
            """) // Remove creatorId later
    Page<Group> listaGrupoUsuarioPage(Long creatorId, Pageable pageable);

    // Group listGroupDetails(Long idGroup);
    // Group findByName(String name);
}
