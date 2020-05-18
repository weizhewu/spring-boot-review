package com.soft1851.springboot.task.schedule.repository;

import com.soft1851.springboot.task.schedule.model.Cron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: zw_w
 * @Date: 2020/5/15 20:37
 * @Description:
 */
public interface CronRepository extends JpaRepository<Cron,Integer> {
    /**
     * 根据cronId查询
     * @param cronId
     * @return
     */
    Cron findCronByCronIdEquals(int cronId);

    /**
     * 根据id修改cron
     * @param cron
     * @param id
     * @return
     */
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "update cron set cron = ?1 where cron_id = ?2", nativeQuery = true)
    void updateCron(String cron, int id);
}