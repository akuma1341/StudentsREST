package com.example.studentsrest;

import com.example.studentsrest.entities.Group;
import com.example.studentsrest.repositories.GroupRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class GroupTests {
    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreatingGroup() {
        Group group = new Group();
        group.setGroupNumber("Number1");
        groupRepository.save(group);
    }

    @Test
    public void testUpdatingGroup() {
        long groupId = 1L;
        Group group = entityManager.find(Group.class, groupId);
        group.setGroupNumber("Number1Updated");
        groupRepository.save(group);
    }

    @Test
    public void testDeletingGroup() {
        long groupId = 1L;
        groupRepository.deleteById(groupId);
    }
}
