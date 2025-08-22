package com.finboostplus.repository;

import com.finboostplus.model.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> {

    /*
     * SELECT u.user_name , u.e_mail FROM users u
     * INNER JOIN member_group members ON members.user_id = u.id
     * INNER JOIN tb_group g ON members.id_group = 2
     */
    @Query(nativeQuery = true, value = """
                SELECT count(*) from group_member as mg
                inner join users as u
                on mg.user_id = u.id
                inner join tb_group as g
                on g.id = mg.id_group where u.id = :userId and g.id = :groupId
                and mg.auth_level = 'OWNER'
            """)
    Integer isUserAndGroupAndAuthorityValidToUpdateGroup(long userId, long groupId);

    List<GroupMember> findByUser_id(Long userId);

    List<GroupMember> findByGroup_Id(Long groupId);
}
