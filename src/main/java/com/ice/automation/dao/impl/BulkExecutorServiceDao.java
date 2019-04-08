//package com.ice.automation.dao.impl;
//
//import com.ice.automation.commons.router.Transaction;
//import com.ice.automation.dao.GenericEntityDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Iterator;
//

//@Service
//public class BulkExecutorServiceDao extends GenericEntityDaoImpl {
//
//    @Autowired
//    private GenericEntityDao<Object> genericEntityDao;
//
//    public void storeLogData(Transaction transaction) {
//        //        List<InMsgHistory> inMsgMosList = response.getInMsgHistoryObjList();
//        //        for (InMsgHistory toPersist : inMsgMosList) {
//        //            genericEntityDao.persist(toPersist);
//        //        }
//        //
//        //        List<OutMsgHistory> outMsgMtsList = response.getOutMsgHistoryObjList();
//        //        for (OutMsgHistory toPersist : outMsgMtsList) {
//        //            genericEntityDao.persist(toPersist);
//        //        }
//
//        for (Iterator<Object> it = transaction.getObjectsToPersist().iterator(); it.hasNext(); ) {
//            genericEntityDao.merge(it.next());
//            it.remove();
//        }
//    }
//
//    public void evictLogData(Transaction transaction) {
//        //        List<InMsgHistory> inMsgMosList = response.getInMsgHistoryObjList();
//        //        for (InMsgHistory toEvict : inMsgMosList) {
//        //            genericEntityDao.evict(toEvict);
//        //        }
//        //        List<OutMsgHistory> outMsgMtsList = response.getOutMsgHistoryObjList();
//        //        for (OutMsgHistory toEvict : outMsgMtsList) {
//        //            genericEntityDao.evict(toEvict);
//        //        }
//    }
//}
