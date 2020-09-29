package com.chaochaogu.daily.loadingcache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author chaochao Gu
 * @date 2020/9/28
 */
public class Client {
    public static void main(String[] args) {
        LoadingCache<Long, User> loadingCache = CacheBuilder.newBuilder().expireAfterAccess(60, SECONDS).build(new CacheLoader<Long, User>() {
            @Override
            public User load(Long key) throws Exception {
                return getUser(key);
            }
        });
        // 模拟缓存刷新，此处内存对象，无需刷新，每次都是最新，后续换成数据库查询即可，意思理解就行
        System.out.println(loadingCache.getUnchecked(2L));
        UserFactory.modifyUserGender();
        loadingCache.refresh(2L);
        System.out.println(loadingCache.getUnchecked(2L));
    }

    public static User getUser(Long key) {
        return UserFactory.getUser();
    }
}
