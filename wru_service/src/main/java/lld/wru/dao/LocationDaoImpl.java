package lld.wru.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import lld.wru.dao.interfaces.LocationDao;
import lld.wru.model.Location;
import lld.wru.model.LocationExample;
import lld.wru.model.LocationExample.Criteria;

@Component
public class LocationDaoImpl implements LocationDao {

    public Location getLocationByPhone(String phoneNum) {
        LocationMapper locationMapper = DaoFactory.getLocationMapper();
        LocationExample example = new LocationExample();
        Criteria criteria = example.createCriteria();
        criteria.andPhoneNumEqualTo(phoneNum);
        List<Location> location = locationMapper.selectByExample(example);
        
        if (location.size() > 0) {
            return location.get(0);
        } else {
            return null;
        }
    }

    public int insertLocation(Location location) {
        LocationMapper locationMapper = DaoFactory.getLocationMapper();
        int updatedCount = locationMapper.insert(location);
        return updatedCount;
    }

    public int updateLocation(Location location) {
        LocationMapper locationMapper = DaoFactory.getLocationMapper();
        int updatedCount = locationMapper.updateByPrimaryKey(location);
        return updatedCount;
    }

}
