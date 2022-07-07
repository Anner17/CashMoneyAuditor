package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_cashFlowAuditor_Models_UserRealmProxy extends com.cashFlowAuditor.Models.User
    implements RealmObjectProxy, com_cashFlowAuditor_Models_UserRealmProxyInterface {

    static final class UserColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idIndex;
        long professionIndex;
        long businessesIndex;

        UserColumnInfo(OsSchemaInfo schemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("User");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.professionIndex = addColumnDetails("profession", "profession", objectSchemaInfo);
            this.businessesIndex = addColumnDetails("businesses", "businesses", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        UserColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new UserColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final UserColumnInfo src = (UserColumnInfo) rawSrc;
            final UserColumnInfo dst = (UserColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.professionIndex = src.professionIndex;
            dst.businessesIndex = src.businessesIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private UserColumnInfo columnInfo;
    private ProxyState<com.cashFlowAuditor.Models.User> proxyState;
    private RealmList<com.cashFlowAuditor.Models.Business> businessesRealmList;

    com_cashFlowAuditor_Models_UserRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (UserColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.cashFlowAuditor.Models.User>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    public com.cashFlowAuditor.Models.Profession realmGet$profession() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.professionIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.cashFlowAuditor.Models.Profession.class, proxyState.getRow$realm().getLink(columnInfo.professionIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$profession(com.cashFlowAuditor.Models.Profession value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("profession")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.professionIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.professionIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.professionIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.professionIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    public RealmList<com.cashFlowAuditor.Models.Business> realmGet$businesses() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (businessesRealmList != null) {
            return businessesRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.businessesIndex);
            businessesRealmList = new RealmList<com.cashFlowAuditor.Models.Business>(com.cashFlowAuditor.Models.Business.class, osList, proxyState.getRealm$realm());
            return businessesRealmList;
        }
    }

    @Override
    public void realmSet$businesses(RealmList<com.cashFlowAuditor.Models.Business> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("businesses")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.cashFlowAuditor.Models.Business> original = value;
                value = new RealmList<com.cashFlowAuditor.Models.Business>();
                for (com.cashFlowAuditor.Models.Business item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.businessesIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.cashFlowAuditor.Models.Business linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.setRow(i, ((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        } else {
            osList.removeAll();
            if (value == null) {
                return;
            }
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.cashFlowAuditor.Models.Business linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("User", 3, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedLinkProperty("profession", RealmFieldType.OBJECT, "Profession");
        builder.addPersistedLinkProperty("businesses", RealmFieldType.LIST, "Business");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static UserColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new UserColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "User";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "User";
    }

    @SuppressWarnings("cast")
    public static com.cashFlowAuditor.Models.User createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(2);
        com.cashFlowAuditor.Models.User obj = null;
        if (update) {
            Table table = realm.getTable(com.cashFlowAuditor.Models.User.class);
            UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.User.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.User.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_cashFlowAuditor_Models_UserRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("profession")) {
                excludeFields.add("profession");
            }
            if (json.has("businesses")) {
                excludeFields.add("businesses");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_cashFlowAuditor_Models_UserRealmProxy) realm.createObjectInternal(com.cashFlowAuditor.Models.User.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_cashFlowAuditor_Models_UserRealmProxy) realm.createObjectInternal(com.cashFlowAuditor.Models.User.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_cashFlowAuditor_Models_UserRealmProxyInterface objProxy = (com_cashFlowAuditor_Models_UserRealmProxyInterface) obj;
        if (json.has("profession")) {
            if (json.isNull("profession")) {
                objProxy.realmSet$profession(null);
            } else {
                com.cashFlowAuditor.Models.Profession professionObj = com_cashFlowAuditor_Models_ProfessionRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("profession"), update);
                objProxy.realmSet$profession(professionObj);
            }
        }
        if (json.has("businesses")) {
            if (json.isNull("businesses")) {
                objProxy.realmSet$businesses(null);
            } else {
                objProxy.realmGet$businesses().clear();
                JSONArray array = json.getJSONArray("businesses");
                for (int i = 0; i < array.length(); i++) {
                    com.cashFlowAuditor.Models.Business item = com_cashFlowAuditor_Models_BusinessRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$businesses().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.cashFlowAuditor.Models.User createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.cashFlowAuditor.Models.User obj = new com.cashFlowAuditor.Models.User();
        final com_cashFlowAuditor_Models_UserRealmProxyInterface objProxy = (com_cashFlowAuditor_Models_UserRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("profession")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$profession(null);
                } else {
                    com.cashFlowAuditor.Models.Profession professionObj = com_cashFlowAuditor_Models_ProfessionRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$profession(professionObj);
                }
            } else if (name.equals("businesses")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$businesses(null);
                } else {
                    objProxy.realmSet$businesses(new RealmList<com.cashFlowAuditor.Models.Business>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.cashFlowAuditor.Models.Business item = com_cashFlowAuditor_Models_BusinessRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$businesses().add(item);
                    }
                    reader.endArray();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    private static com_cashFlowAuditor_Models_UserRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.User.class), false, Collections.<String>emptyList());
        io.realm.com_cashFlowAuditor_Models_UserRealmProxy obj = new io.realm.com_cashFlowAuditor_Models_UserRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.cashFlowAuditor.Models.User copyOrUpdate(Realm realm, UserColumnInfo columnInfo, com.cashFlowAuditor.Models.User object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.cashFlowAuditor.Models.User) cachedRealmObject;
        }

        com.cashFlowAuditor.Models.User realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.cashFlowAuditor.Models.User.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_cashFlowAuditor_Models_UserRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_cashFlowAuditor_Models_UserRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.cashFlowAuditor.Models.User copy(Realm realm, UserColumnInfo columnInfo, com.cashFlowAuditor.Models.User newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.cashFlowAuditor.Models.User) cachedRealmObject;
        }

        com_cashFlowAuditor_Models_UserRealmProxyInterface realmObjectSource = (com_cashFlowAuditor_Models_UserRealmProxyInterface) newObject;

        Table table = realm.getTable(com.cashFlowAuditor.Models.User.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_cashFlowAuditor_Models_UserRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        // Finally add all fields that reference other Realm Objects, either directly or through a list
        com.cashFlowAuditor.Models.Profession professionObj = realmObjectSource.realmGet$profession();
        if (professionObj == null) {
            realmObjectCopy.realmSet$profession(null);
        } else {
            com.cashFlowAuditor.Models.Profession cacheprofession = (com.cashFlowAuditor.Models.Profession) cache.get(professionObj);
            if (cacheprofession != null) {
                realmObjectCopy.realmSet$profession(cacheprofession);
            } else {
                realmObjectCopy.realmSet$profession(com_cashFlowAuditor_Models_ProfessionRealmProxy.copyOrUpdate(realm, (com_cashFlowAuditor_Models_ProfessionRealmProxy.ProfessionColumnInfo) realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.Profession.class), professionObj, update, cache, flags));
            }
        }

        RealmList<com.cashFlowAuditor.Models.Business> businessesList = realmObjectSource.realmGet$businesses();
        if (businessesList != null) {
            RealmList<com.cashFlowAuditor.Models.Business> businessesRealmList = realmObjectCopy.realmGet$businesses();
            businessesRealmList.clear();
            for (int i = 0; i < businessesList.size(); i++) {
                com.cashFlowAuditor.Models.Business businessesItem = businessesList.get(i);
                com.cashFlowAuditor.Models.Business cachebusinesses = (com.cashFlowAuditor.Models.Business) cache.get(businessesItem);
                if (cachebusinesses != null) {
                    businessesRealmList.add(cachebusinesses);
                } else {
                    businessesRealmList.add(com_cashFlowAuditor_Models_BusinessRealmProxy.copyOrUpdate(realm, (com_cashFlowAuditor_Models_BusinessRealmProxy.BusinessColumnInfo) realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.Business.class), businessesItem, update, cache, flags));
                }
            }
        }

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.cashFlowAuditor.Models.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.cashFlowAuditor.Models.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.User.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_cashFlowAuditor_Models_UserRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_cashFlowAuditor_Models_UserRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_cashFlowAuditor_Models_UserRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);

        com.cashFlowAuditor.Models.Profession professionObj = ((com_cashFlowAuditor_Models_UserRealmProxyInterface) object).realmGet$profession();
        if (professionObj != null) {
            Long cacheprofession = cache.get(professionObj);
            if (cacheprofession == null) {
                cacheprofession = com_cashFlowAuditor_Models_ProfessionRealmProxy.insert(realm, professionObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.professionIndex, rowIndex, cacheprofession, false);
        }

        RealmList<com.cashFlowAuditor.Models.Business> businessesList = ((com_cashFlowAuditor_Models_UserRealmProxyInterface) object).realmGet$businesses();
        if (businessesList != null) {
            OsList businessesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.businessesIndex);
            for (com.cashFlowAuditor.Models.Business businessesItem : businessesList) {
                Long cacheItemIndexbusinesses = cache.get(businessesItem);
                if (cacheItemIndexbusinesses == null) {
                    cacheItemIndexbusinesses = com_cashFlowAuditor_Models_BusinessRealmProxy.insert(realm, businessesItem, cache);
                }
                businessesOsList.addRow(cacheItemIndexbusinesses);
            }
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.cashFlowAuditor.Models.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.User.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.cashFlowAuditor.Models.User object = null;
        while (objects.hasNext()) {
            object = (com.cashFlowAuditor.Models.User) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_cashFlowAuditor_Models_UserRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_cashFlowAuditor_Models_UserRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_cashFlowAuditor_Models_UserRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);

            com.cashFlowAuditor.Models.Profession professionObj = ((com_cashFlowAuditor_Models_UserRealmProxyInterface) object).realmGet$profession();
            if (professionObj != null) {
                Long cacheprofession = cache.get(professionObj);
                if (cacheprofession == null) {
                    cacheprofession = com_cashFlowAuditor_Models_ProfessionRealmProxy.insert(realm, professionObj, cache);
                }
                table.setLink(columnInfo.professionIndex, rowIndex, cacheprofession, false);
            }

            RealmList<com.cashFlowAuditor.Models.Business> businessesList = ((com_cashFlowAuditor_Models_UserRealmProxyInterface) object).realmGet$businesses();
            if (businessesList != null) {
                OsList businessesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.businessesIndex);
                for (com.cashFlowAuditor.Models.Business businessesItem : businessesList) {
                    Long cacheItemIndexbusinesses = cache.get(businessesItem);
                    if (cacheItemIndexbusinesses == null) {
                        cacheItemIndexbusinesses = com_cashFlowAuditor_Models_BusinessRealmProxy.insert(realm, businessesItem, cache);
                    }
                    businessesOsList.addRow(cacheItemIndexbusinesses);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.cashFlowAuditor.Models.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.cashFlowAuditor.Models.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.User.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_cashFlowAuditor_Models_UserRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_cashFlowAuditor_Models_UserRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_cashFlowAuditor_Models_UserRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);

        com.cashFlowAuditor.Models.Profession professionObj = ((com_cashFlowAuditor_Models_UserRealmProxyInterface) object).realmGet$profession();
        if (professionObj != null) {
            Long cacheprofession = cache.get(professionObj);
            if (cacheprofession == null) {
                cacheprofession = com_cashFlowAuditor_Models_ProfessionRealmProxy.insertOrUpdate(realm, professionObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.professionIndex, rowIndex, cacheprofession, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.professionIndex, rowIndex);
        }

        OsList businessesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.businessesIndex);
        RealmList<com.cashFlowAuditor.Models.Business> businessesList = ((com_cashFlowAuditor_Models_UserRealmProxyInterface) object).realmGet$businesses();
        if (businessesList != null && businessesList.size() == businessesOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = businessesList.size();
            for (int i = 0; i < objects; i++) {
                com.cashFlowAuditor.Models.Business businessesItem = businessesList.get(i);
                Long cacheItemIndexbusinesses = cache.get(businessesItem);
                if (cacheItemIndexbusinesses == null) {
                    cacheItemIndexbusinesses = com_cashFlowAuditor_Models_BusinessRealmProxy.insertOrUpdate(realm, businessesItem, cache);
                }
                businessesOsList.setRow(i, cacheItemIndexbusinesses);
            }
        } else {
            businessesOsList.removeAll();
            if (businessesList != null) {
                for (com.cashFlowAuditor.Models.Business businessesItem : businessesList) {
                    Long cacheItemIndexbusinesses = cache.get(businessesItem);
                    if (cacheItemIndexbusinesses == null) {
                        cacheItemIndexbusinesses = com_cashFlowAuditor_Models_BusinessRealmProxy.insertOrUpdate(realm, businessesItem, cache);
                    }
                    businessesOsList.addRow(cacheItemIndexbusinesses);
                }
            }
        }

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.cashFlowAuditor.Models.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.User.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.cashFlowAuditor.Models.User object = null;
        while (objects.hasNext()) {
            object = (com.cashFlowAuditor.Models.User) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_cashFlowAuditor_Models_UserRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_cashFlowAuditor_Models_UserRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_cashFlowAuditor_Models_UserRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);

            com.cashFlowAuditor.Models.Profession professionObj = ((com_cashFlowAuditor_Models_UserRealmProxyInterface) object).realmGet$profession();
            if (professionObj != null) {
                Long cacheprofession = cache.get(professionObj);
                if (cacheprofession == null) {
                    cacheprofession = com_cashFlowAuditor_Models_ProfessionRealmProxy.insertOrUpdate(realm, professionObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.professionIndex, rowIndex, cacheprofession, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.professionIndex, rowIndex);
            }

            OsList businessesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.businessesIndex);
            RealmList<com.cashFlowAuditor.Models.Business> businessesList = ((com_cashFlowAuditor_Models_UserRealmProxyInterface) object).realmGet$businesses();
            if (businessesList != null && businessesList.size() == businessesOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = businessesList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.cashFlowAuditor.Models.Business businessesItem = businessesList.get(i);
                    Long cacheItemIndexbusinesses = cache.get(businessesItem);
                    if (cacheItemIndexbusinesses == null) {
                        cacheItemIndexbusinesses = com_cashFlowAuditor_Models_BusinessRealmProxy.insertOrUpdate(realm, businessesItem, cache);
                    }
                    businessesOsList.setRow(i, cacheItemIndexbusinesses);
                }
            } else {
                businessesOsList.removeAll();
                if (businessesList != null) {
                    for (com.cashFlowAuditor.Models.Business businessesItem : businessesList) {
                        Long cacheItemIndexbusinesses = cache.get(businessesItem);
                        if (cacheItemIndexbusinesses == null) {
                            cacheItemIndexbusinesses = com_cashFlowAuditor_Models_BusinessRealmProxy.insertOrUpdate(realm, businessesItem, cache);
                        }
                        businessesOsList.addRow(cacheItemIndexbusinesses);
                    }
                }
            }

        }
    }

    public static com.cashFlowAuditor.Models.User createDetachedCopy(com.cashFlowAuditor.Models.User realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.cashFlowAuditor.Models.User unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.cashFlowAuditor.Models.User();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.cashFlowAuditor.Models.User) cachedObject.object;
            }
            unmanagedObject = (com.cashFlowAuditor.Models.User) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_cashFlowAuditor_Models_UserRealmProxyInterface unmanagedCopy = (com_cashFlowAuditor_Models_UserRealmProxyInterface) unmanagedObject;
        com_cashFlowAuditor_Models_UserRealmProxyInterface realmSource = (com_cashFlowAuditor_Models_UserRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());

        // Deep copy of profession
        unmanagedCopy.realmSet$profession(com_cashFlowAuditor_Models_ProfessionRealmProxy.createDetachedCopy(realmSource.realmGet$profession(), currentDepth + 1, maxDepth, cache));

        // Deep copy of businesses
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$businesses(null);
        } else {
            RealmList<com.cashFlowAuditor.Models.Business> managedbusinessesList = realmSource.realmGet$businesses();
            RealmList<com.cashFlowAuditor.Models.Business> unmanagedbusinessesList = new RealmList<com.cashFlowAuditor.Models.Business>();
            unmanagedCopy.realmSet$businesses(unmanagedbusinessesList);
            int nextDepth = currentDepth + 1;
            int size = managedbusinessesList.size();
            for (int i = 0; i < size; i++) {
                com.cashFlowAuditor.Models.Business item = com_cashFlowAuditor_Models_BusinessRealmProxy.createDetachedCopy(managedbusinessesList.get(i), nextDepth, maxDepth, cache);
                unmanagedbusinessesList.add(item);
            }
        }

        return unmanagedObject;
    }

    static com.cashFlowAuditor.Models.User update(Realm realm, UserColumnInfo columnInfo, com.cashFlowAuditor.Models.User realmObject, com.cashFlowAuditor.Models.User newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_cashFlowAuditor_Models_UserRealmProxyInterface realmObjectTarget = (com_cashFlowAuditor_Models_UserRealmProxyInterface) realmObject;
        com_cashFlowAuditor_Models_UserRealmProxyInterface realmObjectSource = (com_cashFlowAuditor_Models_UserRealmProxyInterface) newObject;
        Table table = realm.getTable(com.cashFlowAuditor.Models.User.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());

        com.cashFlowAuditor.Models.Profession professionObj = realmObjectSource.realmGet$profession();
        if (professionObj == null) {
            builder.addNull(columnInfo.professionIndex);
        } else {
            com.cashFlowAuditor.Models.Profession cacheprofession = (com.cashFlowAuditor.Models.Profession) cache.get(professionObj);
            if (cacheprofession != null) {
                builder.addObject(columnInfo.professionIndex, cacheprofession);
            } else {
                builder.addObject(columnInfo.professionIndex, com_cashFlowAuditor_Models_ProfessionRealmProxy.copyOrUpdate(realm, (com_cashFlowAuditor_Models_ProfessionRealmProxy.ProfessionColumnInfo) realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.Profession.class), professionObj, true, cache, flags));
            }
        }

        RealmList<com.cashFlowAuditor.Models.Business> businessesList = realmObjectSource.realmGet$businesses();
        if (businessesList != null) {
            RealmList<com.cashFlowAuditor.Models.Business> businessesManagedCopy = new RealmList<com.cashFlowAuditor.Models.Business>();
            for (int i = 0; i < businessesList.size(); i++) {
                com.cashFlowAuditor.Models.Business businessesItem = businessesList.get(i);
                com.cashFlowAuditor.Models.Business cachebusinesses = (com.cashFlowAuditor.Models.Business) cache.get(businessesItem);
                if (cachebusinesses != null) {
                    businessesManagedCopy.add(cachebusinesses);
                } else {
                    businessesManagedCopy.add(com_cashFlowAuditor_Models_BusinessRealmProxy.copyOrUpdate(realm, (com_cashFlowAuditor_Models_BusinessRealmProxy.BusinessColumnInfo) realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.Business.class), businessesItem, true, cache, flags));
                }
            }
            builder.addObjectList(columnInfo.businessesIndex, businessesManagedCopy);
        } else {
            builder.addObjectList(columnInfo.businessesIndex, new RealmList<com.cashFlowAuditor.Models.Business>());
        }

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("User = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{profession:");
        stringBuilder.append(realmGet$profession() != null ? "Profession" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{businesses:");
        stringBuilder.append("RealmList<Business>[").append(realmGet$businesses().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_cashFlowAuditor_Models_UserRealmProxy aUser = (com_cashFlowAuditor_Models_UserRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aUser.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aUser.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aUser.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
