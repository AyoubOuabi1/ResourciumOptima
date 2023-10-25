package com.ayoub.resourciumoptima.Services;

import com.ayoub.resourciumoptima.Config.EntityManagerFct;
import com.ayoub.resourciumoptima.entities.Equipment;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentServiceTest {
    static EquipmentService  equipmentService;
    @BeforeAll
    static void init() {
        EntityManagerFct.getEntityManagerFactory();
        equipmentService= new EquipmentService();
    }

    @Test
    void findEquipment() {
        Equipment  equipment=equipmentService.findEquipment(1L);
        assertNotNull(equipment);
    }

    @Test
    void saveEquipment() {
        int sizeBefore=equipmentService.getEquipments().get().size();
        Equipment equipment = new Equipment();
        equipment.setName("test equipment");
        equipment.setType("jetable");
        equipment.setPurchaseDate(new Date(System.currentTimeMillis()));
        equipment.setStatus("available");
        equipment.setMaintenance_date(new Date(System.currentTimeMillis()));
        equipmentService.saveEquipment(equipment);
        int sizeAfter=equipmentService.getEquipments().get().size();
        assertEquals(sizeAfter, sizeBefore + 1);
    }

    @Test
    void removeEquipment() throws Exception {
         equipmentService.removeEquipment(303L);
        Equipment  equipment=equipmentService.findEquipment(303L);
        assertNull(equipment);

    }

    @Test
    void updateEquipment() throws Exception {
        Equipment  equipment=equipmentService.findEquipment(303L);
        String name=equipment.getName();
        equipment.setName("equipment after update");
        equipmentService.updateEquipment(equipment);
        assertNotEquals(name, equipment.getName());
    }

    @Test
    void getEquipments() {
        int s=equipmentService.getEquipments().get().size();
        assertTrue(s>0);

    }
}