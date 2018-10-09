package com.weli.account.bean.repository;


import com.weli.account.bean.gen.DaoSession;
import com.weli.account.bean.gen.LocalAccountDao;
import com.weli.account.bean.local.LocalAccount;
import com.weli.account.utils.DateUtils;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.Date;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;


public class LocalRepository {

    private static final String TAG = "LocalRepository";
    private static final String DISTILLATE_ALL = "normal";
    private static final String DISTILLATE_BOUTIQUES = "distillate";

    private static volatile LocalRepository sInstance;
    private DaoSession mSession;

    private LocalRepository() {
        mSession = DaoDbHelper.getInstance().getSession();
    }

    public static LocalRepository getInstance() {
        if (sInstance == null) {
            synchronized (LocalRepository.class) {
                if (sInstance == null) {
                    sInstance = new LocalRepository();
                }
            }
        }
        return sInstance;
    }

    /******************************save**************************************/
    public Observable<LocalAccount> saveBBill(final LocalAccount bill) {
        return Observable.create(new ObservableOnSubscribe<LocalAccount>() {
            @Override
            public void subscribe(ObservableEmitter<LocalAccount> e) throws Exception {
                mSession.getLocalAccountDao().insert(bill);
                e.onNext(bill);
                e.onComplete();
            }
        });
    }

    /**
     * 批量添加账单
     *
     * @param bBills
     */
    public void saveBBills(List<LocalAccount> bBills) {
        mSession.getLocalAccountDao().insertInTx(bBills);
    }


    /******************************get**************************************/

    public Observable<List<LocalAccount>> getAccount() {
//        return mSession.getLocalAccountDao().queryBuilder().list()
        QueryBuilder<LocalAccount> queryBuilder = mSession.getLocalAccountDao()
                .queryBuilder();
        return  queryListToRx(queryBuilder);
    }

    public Observable<List<LocalAccount>> getBBillByUserId(int id) {
        QueryBuilder<LocalAccount> queryBuilder = mSession.getLocalAccountDao()
                .queryBuilder()
                .where(LocalAccountDao.Properties.Userid.eq(id));
        return queryListToRx(queryBuilder);
    }

    public Observable<List<LocalAccount>> getBBillByUserIdWithYM(int id, String year, String month) {
        String startStr = year + "-" + month + "-00 00:00:00";
        Date date = DateUtils.str2Date(startStr);
        Date endDate = DateUtils.addMonth(date, 1);
        QueryBuilder<LocalAccount> queryBuilder = mSession.getLocalAccountDao()
                .queryBuilder()
                .where(LocalAccountDao.Properties.Crdate.between(DateUtils.getMillis(date), DateUtils.getMillis(endDate)))

                .orderDesc(LocalAccountDao.Properties.Crdate);
        return queryListToRx(queryBuilder);
    }


    /******************************update**************************************/

    /**
     * 更新账单（用于同步）
     *
     * @param bill
     */
    public void updateBBillByBmob(LocalAccount bill) {
        mSession.getLocalAccountDao().update(bill);
    }

    /**
     * 更新账单
     *
     * @param bill
     * @return
     */
    public Observable<LocalAccount> updateBBill(final LocalAccount bill) {

        return Observable.create(new ObservableOnSubscribe<LocalAccount>() {
            @Override
            public void subscribe(ObservableEmitter<LocalAccount> e) throws Exception {
                mSession.getLocalAccountDao().update(bill);
                e.onNext(bill);
                e.onComplete();
            }
        });
    }

    /******************************delete**************************************/


    /**
     * 批量删除账单（便于账单同步）
     *
     * @param bBills
     */
    public void deleteBills(List<LocalAccount> bBills) {
        mSession.getLocalAccountDao().deleteInTx(bBills);
    }



    public Observable<Long> deleteBBillById(Long id) {
        mSession.getLocalAccountDao().deleteByKey(id);
        return Observable.create(new ObservableOnSubscribe<Long>() {
            @Override
            public void subscribe(ObservableEmitter<Long> e) throws Exception {
                e.onNext(new Long(0));
                e.onComplete();
            }
        });
    }

    /******************************Rx**************************************/
    private <T> Observable<T> queryToRx(final QueryBuilder<T> builder) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> e) throws Exception {
                T data = builder.list().get(0);
                e.onNext(data);
                e.onComplete();
            }
        });
    }

    private <T> Observable<List<T>> queryListToRx(final QueryBuilder<T> builder) {
        return Observable.create(new ObservableOnSubscribe<List<T>>() {
            @Override
            public void subscribe(ObservableEmitter<List<T>> e) throws Exception {
                List<T> data = builder.list();
                e.onNext(data);
                e.onComplete();
            }
        });
    }

}
