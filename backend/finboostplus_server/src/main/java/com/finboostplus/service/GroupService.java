package com.finboostplus.service;

import com.finboostplus.DTO.GroupDto;
import com.finboostplus.DTO.GroupUpdateDTO;
import com.finboostplus.model.Group;
import com.finboostplus.model.GroupMember;
import com.finboostplus.model.GroupMemberId;
import com.finboostplus.model.User;
import com.finboostplus.repository.GroupMemberRepository;
import com.finboostplus.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import com.finboostplus.service.UserService;
import com.finboostplus.repository.UserRepository;
import com.finboostplus.exception.ForbiddenResourceException;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import com.finboostplus.exception.UserNotFoundException;

@Service
public class GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    GroupMemberRepository groupMemberRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    public Group createNewGroup(GroupDto groupDto, User user) {

        GroupMember groupMember = new GroupMember();
        Group group = groupDto.groupDtoToGroup();
        group.setGroupCreatorId(user.getId());
        group = groupRepository.save(group);

        if (group != null) {

            GroupMemberId groupMemberId = new GroupMemberId(group.getId(), user.getId());

            groupMember.setId(groupMemberId);
            groupMember.setGroup(group);
            groupMember.setUser(user);
            groupMember.setAuthorization("ONWER");

            groupMemberRepository.save(groupMember);

            return group;
        }

        return null;

    }

    public boolean addMemberGroup(Long id, String email) {

        return false;
    }

    @Transactional
    public Optional<Group> updateGroup(Long id, GroupUpdateDTO groupDto) {
        String username = userService.authenticated();
        Optional<User> user = userRepository.findByEmailIgnoreCase(username);
        if (user.isEmpty()) {
            throw new UserNotFoundException("Usuário não encontrado");
        }
        Long userId = user.get().getId();
        Integer isValid = groupMemberRepository.isUserAndGroupAndAuthorityValidToUpdateGroup(
                userId, id);
        if (isValid >= 1) {
            Optional<Group> optional = groupRepository.findById(id);
            Group group = optional.get();
            if (groupDto.name() != null && !groupDto.name().equals("")) {
                group.setName(groupDto.name());
            }
            if (groupDto.description() != null) {
                group.setDescription(groupDto.description());
            }
            return Optional.ofNullable(groupRepository.save(group));
        } else {
            throw new ForbiddenResourceException("Usuário sem permissão");
        }
    }
    // public List<Group> listGroupCreator(Long userId, Pageable pageable){
    //
    // return groupRepository.listaGrupoUsuario(userId,pageable);
    // }

    public Page<Group> listCreatorGroupPage(Long userId, Pageable pageable) {

        return groupRepository.listaGrupoUsuarioPage(userId, pageable);
    }

}
