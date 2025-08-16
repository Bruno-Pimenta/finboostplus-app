package com.finboostplus.service;

import com.finboostplus.DTO.GroupDto;
import com.finboostplus.model.Group;
import com.finboostplus.model.User;
import com.finboostplus.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    @Autowired
    GroupRepository groupRepository;

    public Group createNewGroup(GroupDto groupDto){

        Group group;
        group = groupDto.groupDtoToGroup();

        return groupRepository.save(group);
    }
}
