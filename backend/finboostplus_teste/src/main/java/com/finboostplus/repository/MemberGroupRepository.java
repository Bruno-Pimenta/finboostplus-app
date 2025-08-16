package com.finboostplus.repository;

import com.finboostplus.model.MemberGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberGroupRepository extends JpaRepository<MemberGroup,Long> {

    /*
        SELECT u.user_name , u.e_mail FROM users u
        INNER JOIN member_group members ON members.user_id = u.id
       INNER JOIN tb_group g ON members.id_group = 2
    * */

    List<MemberGroup> findByUser_id(Long userId);

    List<MemberGroup> findByGroup_Id(Long groupId);
}
