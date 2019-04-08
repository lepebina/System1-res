//package com.ice.automation.dao.impl;
//
//
//import com.ice.automation.dao.RoutingEntityDao;
//import com.ice.automation.model.cfg.RoutingEntity;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Repository("routingEntityDao")
//public class RoutingEntityDaoImpl extends GenericEntityDaoImpl<RoutingEntity> implements RoutingEntityDao {
//
//    @Transactional(readOnly = true)
//    public List<RoutingEntity> getRoutings() {
//        return sessionFactory.getCurrentSession().createQuery("select r from RoutingEntity r").list();
//    }
//}
