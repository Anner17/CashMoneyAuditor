package io.realm;


import android.util.JsonReader;
import io.realm.ImportFlag;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>(4);
        modelClasses.add(com.cashFlowAuditor.Models.Business.class);
        modelClasses.add(com.cashFlowAuditor.Models.Profession.class);
        modelClasses.add(com.cashFlowAuditor.Models.Stock.class);
        modelClasses.add(com.cashFlowAuditor.Models.User.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<Class<? extends RealmModel>, OsObjectSchemaInfo>(4);
        infoMap.put(com.cashFlowAuditor.Models.Business.class, io.realm.com_cashFlowAuditor_Models_BusinessRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.cashFlowAuditor.Models.Profession.class, io.realm.com_cashFlowAuditor_Models_ProfessionRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.cashFlowAuditor.Models.Stock.class, io.realm.com_cashFlowAuditor_Models_StockRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.cashFlowAuditor.Models.User.class, io.realm.com_cashFlowAuditor_Models_UserRealmProxy.getExpectedObjectSchemaInfo());
        return infoMap;
    }

    @Override
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> clazz, OsSchemaInfo schemaInfo) {
        checkClass(clazz);

        if (clazz.equals(com.cashFlowAuditor.Models.Business.class)) {
            return io.realm.com_cashFlowAuditor_Models_BusinessRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.cashFlowAuditor.Models.Profession.class)) {
            return io.realm.com_cashFlowAuditor_Models_ProfessionRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.cashFlowAuditor.Models.Stock.class)) {
            return io.realm.com_cashFlowAuditor_Models_StockRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.cashFlowAuditor.Models.User.class)) {
            return io.realm.com_cashFlowAuditor_Models_UserRealmProxy.createColumnInfo(schemaInfo);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getSimpleClassNameImpl(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.cashFlowAuditor.Models.Business.class)) {
            return "Business";
        }
        if (clazz.equals(com.cashFlowAuditor.Models.Profession.class)) {
            return "Profession";
        }
        if (clazz.equals(com.cashFlowAuditor.Models.Stock.class)) {
            return "Stock";
        }
        if (clazz.equals(com.cashFlowAuditor.Models.User.class)) {
            return "User";
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.cashFlowAuditor.Models.Business.class)) {
                return clazz.cast(new io.realm.com_cashFlowAuditor_Models_BusinessRealmProxy());
            }
            if (clazz.equals(com.cashFlowAuditor.Models.Profession.class)) {
                return clazz.cast(new io.realm.com_cashFlowAuditor_Models_ProfessionRealmProxy());
            }
            if (clazz.equals(com.cashFlowAuditor.Models.Stock.class)) {
                return clazz.cast(new io.realm.com_cashFlowAuditor_Models_StockRealmProxy());
            }
            if (clazz.equals(com.cashFlowAuditor.Models.User.class)) {
                return clazz.cast(new io.realm.com_cashFlowAuditor_Models_UserRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.cashFlowAuditor.Models.Business.class)) {
            com_cashFlowAuditor_Models_BusinessRealmProxy.BusinessColumnInfo columnInfo = (com_cashFlowAuditor_Models_BusinessRealmProxy.BusinessColumnInfo) realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.Business.class);
            return clazz.cast(io.realm.com_cashFlowAuditor_Models_BusinessRealmProxy.copyOrUpdate(realm, columnInfo, (com.cashFlowAuditor.Models.Business) obj, update, cache, flags));
        }
        if (clazz.equals(com.cashFlowAuditor.Models.Profession.class)) {
            com_cashFlowAuditor_Models_ProfessionRealmProxy.ProfessionColumnInfo columnInfo = (com_cashFlowAuditor_Models_ProfessionRealmProxy.ProfessionColumnInfo) realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.Profession.class);
            return clazz.cast(io.realm.com_cashFlowAuditor_Models_ProfessionRealmProxy.copyOrUpdate(realm, columnInfo, (com.cashFlowAuditor.Models.Profession) obj, update, cache, flags));
        }
        if (clazz.equals(com.cashFlowAuditor.Models.Stock.class)) {
            com_cashFlowAuditor_Models_StockRealmProxy.StockColumnInfo columnInfo = (com_cashFlowAuditor_Models_StockRealmProxy.StockColumnInfo) realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.Stock.class);
            return clazz.cast(io.realm.com_cashFlowAuditor_Models_StockRealmProxy.copyOrUpdate(realm, columnInfo, (com.cashFlowAuditor.Models.Stock) obj, update, cache, flags));
        }
        if (clazz.equals(com.cashFlowAuditor.Models.User.class)) {
            com_cashFlowAuditor_Models_UserRealmProxy.UserColumnInfo columnInfo = (com_cashFlowAuditor_Models_UserRealmProxy.UserColumnInfo) realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.User.class);
            return clazz.cast(io.realm.com_cashFlowAuditor_Models_UserRealmProxy.copyOrUpdate(realm, columnInfo, (com.cashFlowAuditor.Models.User) obj, update, cache, flags));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.cashFlowAuditor.Models.Business.class)) {
            io.realm.com_cashFlowAuditor_Models_BusinessRealmProxy.insert(realm, (com.cashFlowAuditor.Models.Business) object, cache);
        } else if (clazz.equals(com.cashFlowAuditor.Models.Profession.class)) {
            io.realm.com_cashFlowAuditor_Models_ProfessionRealmProxy.insert(realm, (com.cashFlowAuditor.Models.Profession) object, cache);
        } else if (clazz.equals(com.cashFlowAuditor.Models.Stock.class)) {
            io.realm.com_cashFlowAuditor_Models_StockRealmProxy.insert(realm, (com.cashFlowAuditor.Models.Stock) object, cache);
        } else if (clazz.equals(com.cashFlowAuditor.Models.User.class)) {
            io.realm.com_cashFlowAuditor_Models_UserRealmProxy.insert(realm, (com.cashFlowAuditor.Models.User) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.cashFlowAuditor.Models.Business.class)) {
                io.realm.com_cashFlowAuditor_Models_BusinessRealmProxy.insert(realm, (com.cashFlowAuditor.Models.Business) object, cache);
            } else if (clazz.equals(com.cashFlowAuditor.Models.Profession.class)) {
                io.realm.com_cashFlowAuditor_Models_ProfessionRealmProxy.insert(realm, (com.cashFlowAuditor.Models.Profession) object, cache);
            } else if (clazz.equals(com.cashFlowAuditor.Models.Stock.class)) {
                io.realm.com_cashFlowAuditor_Models_StockRealmProxy.insert(realm, (com.cashFlowAuditor.Models.Stock) object, cache);
            } else if (clazz.equals(com.cashFlowAuditor.Models.User.class)) {
                io.realm.com_cashFlowAuditor_Models_UserRealmProxy.insert(realm, (com.cashFlowAuditor.Models.User) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.cashFlowAuditor.Models.Business.class)) {
                    io.realm.com_cashFlowAuditor_Models_BusinessRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.cashFlowAuditor.Models.Profession.class)) {
                    io.realm.com_cashFlowAuditor_Models_ProfessionRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.cashFlowAuditor.Models.Stock.class)) {
                    io.realm.com_cashFlowAuditor_Models_StockRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.cashFlowAuditor.Models.User.class)) {
                    io.realm.com_cashFlowAuditor_Models_UserRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.cashFlowAuditor.Models.Business.class)) {
            io.realm.com_cashFlowAuditor_Models_BusinessRealmProxy.insertOrUpdate(realm, (com.cashFlowAuditor.Models.Business) obj, cache);
        } else if (clazz.equals(com.cashFlowAuditor.Models.Profession.class)) {
            io.realm.com_cashFlowAuditor_Models_ProfessionRealmProxy.insertOrUpdate(realm, (com.cashFlowAuditor.Models.Profession) obj, cache);
        } else if (clazz.equals(com.cashFlowAuditor.Models.Stock.class)) {
            io.realm.com_cashFlowAuditor_Models_StockRealmProxy.insertOrUpdate(realm, (com.cashFlowAuditor.Models.Stock) obj, cache);
        } else if (clazz.equals(com.cashFlowAuditor.Models.User.class)) {
            io.realm.com_cashFlowAuditor_Models_UserRealmProxy.insertOrUpdate(realm, (com.cashFlowAuditor.Models.User) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.cashFlowAuditor.Models.Business.class)) {
                io.realm.com_cashFlowAuditor_Models_BusinessRealmProxy.insertOrUpdate(realm, (com.cashFlowAuditor.Models.Business) object, cache);
            } else if (clazz.equals(com.cashFlowAuditor.Models.Profession.class)) {
                io.realm.com_cashFlowAuditor_Models_ProfessionRealmProxy.insertOrUpdate(realm, (com.cashFlowAuditor.Models.Profession) object, cache);
            } else if (clazz.equals(com.cashFlowAuditor.Models.Stock.class)) {
                io.realm.com_cashFlowAuditor_Models_StockRealmProxy.insertOrUpdate(realm, (com.cashFlowAuditor.Models.Stock) object, cache);
            } else if (clazz.equals(com.cashFlowAuditor.Models.User.class)) {
                io.realm.com_cashFlowAuditor_Models_UserRealmProxy.insertOrUpdate(realm, (com.cashFlowAuditor.Models.User) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.cashFlowAuditor.Models.Business.class)) {
                    io.realm.com_cashFlowAuditor_Models_BusinessRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.cashFlowAuditor.Models.Profession.class)) {
                    io.realm.com_cashFlowAuditor_Models_ProfessionRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.cashFlowAuditor.Models.Stock.class)) {
                    io.realm.com_cashFlowAuditor_Models_StockRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.cashFlowAuditor.Models.User.class)) {
                    io.realm.com_cashFlowAuditor_Models_UserRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.cashFlowAuditor.Models.Business.class)) {
            return clazz.cast(io.realm.com_cashFlowAuditor_Models_BusinessRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.cashFlowAuditor.Models.Profession.class)) {
            return clazz.cast(io.realm.com_cashFlowAuditor_Models_ProfessionRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.cashFlowAuditor.Models.Stock.class)) {
            return clazz.cast(io.realm.com_cashFlowAuditor_Models_StockRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.cashFlowAuditor.Models.User.class)) {
            return clazz.cast(io.realm.com_cashFlowAuditor_Models_UserRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.cashFlowAuditor.Models.Business.class)) {
            return clazz.cast(io.realm.com_cashFlowAuditor_Models_BusinessRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.cashFlowAuditor.Models.Profession.class)) {
            return clazz.cast(io.realm.com_cashFlowAuditor_Models_ProfessionRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.cashFlowAuditor.Models.Stock.class)) {
            return clazz.cast(io.realm.com_cashFlowAuditor_Models_StockRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.cashFlowAuditor.Models.User.class)) {
            return clazz.cast(io.realm.com_cashFlowAuditor_Models_UserRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.cashFlowAuditor.Models.Business.class)) {
            return clazz.cast(io.realm.com_cashFlowAuditor_Models_BusinessRealmProxy.createDetachedCopy((com.cashFlowAuditor.Models.Business) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.cashFlowAuditor.Models.Profession.class)) {
            return clazz.cast(io.realm.com_cashFlowAuditor_Models_ProfessionRealmProxy.createDetachedCopy((com.cashFlowAuditor.Models.Profession) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.cashFlowAuditor.Models.Stock.class)) {
            return clazz.cast(io.realm.com_cashFlowAuditor_Models_StockRealmProxy.createDetachedCopy((com.cashFlowAuditor.Models.Stock) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.cashFlowAuditor.Models.User.class)) {
            return clazz.cast(io.realm.com_cashFlowAuditor_Models_UserRealmProxy.createDetachedCopy((com.cashFlowAuditor.Models.User) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

}
