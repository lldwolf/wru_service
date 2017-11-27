package wru_service.dao;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lld.wru.dao.DaoConfig;
import lld.wru.dao.interfaces.LocationDao;
import lld.wru.model.Location;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoConfig.class)
public class LocationDaoTest {
    @Autowired
    private LocationDao locationDao;

    @Test
    public void insertLocation() {
        Location location = new Location();
        location.setPhoneNum("13817024379");
        location.setRecordTime(LocalDateTime.now().toString());
        location.setLatitude(0.0);
        location.setLongitude(0.0);
        int updatedCount = locationDao.insertLocation(location);
        System.out.println(String.format("%s records inserted", updatedCount));

        location = new Location();
        location.setPhoneNum("13916253764");
        location.setRecordTime(LocalDateTime.now().toString());
        location.setLatitude(0.0);
        location.setLongitude(0.0);
        updatedCount = locationDao.insertLocation(location);
        System.out.println(String.format("%s records inserted", updatedCount));
    }

    @Test
    public void updateLocation() {
        Location location = locationDao.getLocationByPhone("13817024379");
        location.setRecordTime(LocalDateTime.now().toString());
        location.setLongitude(1.0);
        location.setLatitude(1.0);
        int updatedCount = locationDao.updateLocation(location);
        System.out.println(String.format("%s records inserted", updatedCount));
    }
}
