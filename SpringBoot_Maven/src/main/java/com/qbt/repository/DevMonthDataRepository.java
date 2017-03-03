package com.qbt.repository;

import com.qbt.domain.DevMonthData;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by ALKL on 2017/1/3.
 */
/*@RepositoryRestResource(collectionResourceRel = "devMonthData", path = "devMonthData")
public interface DevMonthDataRepository {
    DevMonthData findByUserNo(@Param("userNo") String userNo);

    @Procedure(name = "in_only_test")inOnlyTest
    DevMonthData inonlytest(@Param("did") String did);
}*/

public interface DevMonthDataRepository extends CrudRepository<DevMonthData,Long>{
    @Procedure(name = "user_jpa")
    void UserJpa (@Param("din") int din);
}