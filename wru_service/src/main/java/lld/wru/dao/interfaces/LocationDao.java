package lld.wru.dao.interfaces;

import lld.wru.model.Location;

public interface LocationDao {
    Location getLocationByPhone(String phoneNum);

    int insertLocation(Location location);

    int updateLocation(Location location);
}
