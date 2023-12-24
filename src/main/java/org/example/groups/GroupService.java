package org.example.groups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public List<Group> getGroups(){
        return groupRepository.findAll();
    }

    public static GroupDTO mapToDTO(Group group) {
        return GroupDTO.builder()
                .id(group.getId())
                .name(group.getName())
                .language(group.getLanguage())
                .studentCount(group.getStudentCount())
                .courses(group.getCourses())
                .build();
    }

    public List<GroupDTO> getGroupsDTO() {
        List<Group> groups = getGroups();
        List<GroupDTO> groupDTOS = new ArrayList<>();
        for (Group group : groups) {
            groupDTOS.add(mapToDTO(group));
        }
        return groupDTOS;
    }
}
