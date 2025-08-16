package com.finboostplus;

import com.finboostplus.model.Group;
import com.finboostplus.model.MemberGroup;
import com.finboostplus.model.MemberGroupId;
import com.finboostplus.model.User;
import com.finboostplus.repository.GroupRepository;
import com.finboostplus.repository.MemberGroupRepository;
import com.finboostplus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@SpringBootApplication
@EnableJpaAuditing
public class DemoApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    MemberGroupRepository memberGroupRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
//
//        Optional<User> userOptional = userRepository.findByEmailIgnoreCase("crdornellesffy@gmaiL.bol");
//        Group group = new Group();
//        group.setName("Passeio");
//        group.setDescription("Passeio no parque de diversões");
//
//         var groupSave = groupRepository.save(group);
//         var user = userOptional.get();
//
//        MemberGroup members = new MemberGroup();
//        members.setUser(user);
//        members.setGroup(groupSave);
//        members.setId(new MemberGroupId(user.getId(),groupSave.getId()));
//
//        memberGroupRepository.save(members);




    }
}
