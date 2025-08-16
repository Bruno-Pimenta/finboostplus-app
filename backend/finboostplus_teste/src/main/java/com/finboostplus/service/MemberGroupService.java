package com.finboostplus.service;

import com.finboostplus.DTO.GroupDto;
import com.finboostplus.DTO.UserRequestDTO;
import com.finboostplus.model.Group;
import com.finboostplus.model.MemberGroup;
import com.finboostplus.model.MemberGroupId;
import com.finboostplus.model.User;
import com.finboostplus.repository.GroupRepository;
import com.finboostplus.repository.MemberGroupRepository;
import com.finboostplus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberGroupService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    MemberGroupRepository memberGroupRepository;

    public void  addUserGroup(UserRequestDTO userRequestDTO, GroupDto groupDto, String authorization){
        Optional<User> userOptional = userRepository.findByEmailIgnoreCase(userRequestDTO.email());
        var user = userOptional.get();

        Optional<Group> groupOptional = groupRepository.findById(Long.parseLong(String.valueOf(groupDto.id())));
        var group = groupOptional.get();

        if(user !=null && group != null){
            MemberGroup members = new MemberGroup();
            members.setUser(user);
            members.setGroup(group);
            members.setAuthorization(authorization);
            members.setId(new MemberGroupId(user.getId(),group.getId()));
            memberGroupRepository.save(members);
        }

    }
}
