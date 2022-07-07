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
public class com_cashFlowAuditor_Models_BusinessRealmProxy extends com.cashFlowAuditor.Models.Business
    implements RealmObjectProxy, com_cashFlowAuditor_Models_BusinessRealmProxyInterface {

    static final class BusinessColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idIndex;
        long NameIndex;
        long DownPayIndex;
        long CostIndex;
        long CashFlowIndex;

        BusinessColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Business");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.NameIndex = addColumnDetails("Name", "Name", objectSchemaInfo);
            this.DownPayIndex = addColumnDetails("DownPay", "DownPay", objectSchemaInfo);
            this.CostIndex = addColumnDetails("Cost", "Cost", objectSchemaInfo);
            this.CashFlowIndex = addColumnDetails("CashFlow", "CashFlow", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        BusinessColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new BusinessColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final BusinessColumnInfo src = (BusinessColumnInfo) rawSrc;
            final BusinessColumnInfo dst = (BusinessColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.NameIndex = src.NameIndex;
            dst.DownPayIndex = src.DownPayIndex;
            dst.CostIndex = src.CostIndex;
            dst.CashFlowIndex = src.CashFlowIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private BusinessColumnInfo columnInfo;
    private ProxyState<com.cashFlowAuditor.Models.Business> proxyState;

    com_cashFlowAuditor_Models_BusinessRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (BusinessColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.cashFlowAuditor.Models.Business>(this);
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
    @SuppressWarnings("cast")
    public String realmGet$Name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.NameIndex);
    }

    @Override
    public void realmSet$Name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.NameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.NameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.NameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.NameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$DownPay() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.DownPayIndex);
    }

    @Override
    public void realmSet$DownPay(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.DownPayIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.DownPayIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$Cost() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.CostIndex);
    }

    @Override
    public void realmSet$Cost(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.CostIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.CostIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$CashFlow() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.CashFlowIndex);
    }

    @Override
    public void realmSet$CashFlow(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.CashFlowIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.CashFlowIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Business", 5, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("Name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("DownPay", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("Cost", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("CashFlow", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static BusinessColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new BusinessColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Business";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Business";
    }

    @SuppressWarnings("cast")
    public static com.cashFlowAuditor.Models.Business createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.cashFlowAuditor.Models.Business obj = null;
        if (update) {
            Table table = realm.getTable(com.cashFlowAuditor.Models.Business.class);
            BusinessColumnInfo columnInfo = (BusinessColumnInfo) realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.Business.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.Business.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_cashFlowAuditor_Models_BusinessRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_cashFlowAuditor_Models_BusinessRealmProxy) realm.createObjectInternal(com.cashFlowAuditor.Models.Business.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_cashFlowAuditor_Models_BusinessRealmProxy) realm.createObjectInternal(com.cashFlowAuditor.Models.Business.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_cashFlowAuditor_Models_BusinessRealmProxyInterface objProxy = (com_cashFlowAuditor_Models_BusinessRealmProxyInterface) obj;
        if (json.has("Name")) {
            if (json.isNull("Name")) {
                objProxy.realmSet$Name(null);
            } else {
                objProxy.realmSet$Name((String) json.getString("Name"));
            }
        }
        if (json.has("DownPay")) {
            if (json.isNull("DownPay")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'DownPay' to null.");
            } else {
                objProxy.realmSet$DownPay((int) json.getInt("DownPay"));
            }
        }
        if (json.has("Cost")) {
            if (json.isNull("Cost")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'Cost' to null.");
            } else {
                objProxy.realmSet$Cost((int) json.getInt("Cost"));
            }
        }
        if (json.has("CashFlow")) {
            if (json.isNull("CashFlow")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'CashFlow' to null.");
            } else {
                objProxy.realmSet$CashFlow((int) json.getInt("CashFlow"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.cashFlowAuditor.Models.Business createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.cashFlowAuditor.Models.Business obj = new com.cashFlowAuditor.Models.Business();
        final com_cashFlowAuditor_Models_BusinessRealmProxyInterface objProxy = (com_cashFlowAuditor_Models_BusinessRealmProxyInterface) obj;
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
            } else if (name.equals("Name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Name(null);
                }
            } else if (name.equals("DownPay")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$DownPay((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'DownPay' to null.");
                }
            } else if (name.equals("Cost")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Cost((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'Cost' to null.");
                }
            } else if (name.equals("CashFlow")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$CashFlow((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'CashFlow' to null.");
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

    private static com_cashFlowAuditor_Models_BusinessRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.Business.class), false, Collections.<String>emptyList());
        io.realm.com_cashFlowAuditor_Models_BusinessRealmProxy obj = new io.realm.com_cashFlowAuditor_Models_BusinessRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.cashFlowAuditor.Models.Business copyOrUpdate(Realm realm, BusinessColumnInfo columnInfo, com.cashFlowAuditor.Models.Business object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.cashFlowAuditor.Models.Business) cachedRealmObject;
        }

        com.cashFlowAuditor.Models.Business realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.cashFlowAuditor.Models.Business.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_cashFlowAuditor_Models_BusinessRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.cashFlowAuditor.Models.Business copy(Realm realm, BusinessColumnInfo columnInfo, com.cashFlowAuditor.Models.Business newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.cashFlowAuditor.Models.Business) cachedRealmObject;
        }

        com_cashFlowAuditor_Models_BusinessRealmProxyInterface realmObjectSource = (com_cashFlowAuditor_Models_BusinessRealmProxyInterface) newObject;

        Table table = realm.getTable(com.cashFlowAuditor.Models.Business.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.NameIndex, realmObjectSource.realmGet$Name());
        builder.addInteger(columnInfo.DownPayIndex, realmObjectSource.realmGet$DownPay());
        builder.addInteger(columnInfo.CostIndex, realmObjectSource.realmGet$Cost());
        builder.addInteger(columnInfo.CashFlowIndex, realmObjectSource.realmGet$CashFlow());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_cashFlowAuditor_Models_BusinessRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.cashFlowAuditor.Models.Business object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.cashFlowAuditor.Models.Business.class);
        long tableNativePtr = table.getNativePtr();
        BusinessColumnInfo columnInfo = (BusinessColumnInfo) realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.Business.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$Name = ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$Name();
        if (realmGet$Name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.NameIndex, rowIndex, realmGet$Name, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.DownPayIndex, rowIndex, ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$DownPay(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.CostIndex, rowIndex, ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$Cost(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.CashFlowIndex, rowIndex, ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$CashFlow(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.cashFlowAuditor.Models.Business.class);
        long tableNativePtr = table.getNativePtr();
        BusinessColumnInfo columnInfo = (BusinessColumnInfo) realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.Business.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.cashFlowAuditor.Models.Business object = null;
        while (objects.hasNext()) {
            object = (com.cashFlowAuditor.Models.Business) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$Name = ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$Name();
            if (realmGet$Name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.NameIndex, rowIndex, realmGet$Name, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.DownPayIndex, rowIndex, ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$DownPay(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.CostIndex, rowIndex, ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$Cost(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.CashFlowIndex, rowIndex, ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$CashFlow(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.cashFlowAuditor.Models.Business object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.cashFlowAuditor.Models.Business.class);
        long tableNativePtr = table.getNativePtr();
        BusinessColumnInfo columnInfo = (BusinessColumnInfo) realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.Business.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$Name = ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$Name();
        if (realmGet$Name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.NameIndex, rowIndex, realmGet$Name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.NameIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.DownPayIndex, rowIndex, ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$DownPay(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.CostIndex, rowIndex, ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$Cost(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.CashFlowIndex, rowIndex, ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$CashFlow(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.cashFlowAuditor.Models.Business.class);
        long tableNativePtr = table.getNativePtr();
        BusinessColumnInfo columnInfo = (BusinessColumnInfo) realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.Business.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.cashFlowAuditor.Models.Business object = null;
        while (objects.hasNext()) {
            object = (com.cashFlowAuditor.Models.Business) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            String realmGet$Name = ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$Name();
            if (realmGet$Name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.NameIndex, rowIndex, realmGet$Name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.NameIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.DownPayIndex, rowIndex, ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$DownPay(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.CostIndex, rowIndex, ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$Cost(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.CashFlowIndex, rowIndex, ((com_cashFlowAuditor_Models_BusinessRealmProxyInterface) object).realmGet$CashFlow(), false);
        }
    }

    public static com.cashFlowAuditor.Models.Business createDetachedCopy(com.cashFlowAuditor.Models.Business realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.cashFlowAuditor.Models.Business unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.cashFlowAuditor.Models.Business();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.cashFlowAuditor.Models.Business) cachedObject.object;
            }
            unmanagedObject = (com.cashFlowAuditor.Models.Business) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_cashFlowAuditor_Models_BusinessRealmProxyInterface unmanagedCopy = (com_cashFlowAuditor_Models_BusinessRealmProxyInterface) unmanagedObject;
        com_cashFlowAuditor_Models_BusinessRealmProxyInterface realmSource = (com_cashFlowAuditor_Models_BusinessRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$Name(realmSource.realmGet$Name());
        unmanagedCopy.realmSet$DownPay(realmSource.realmGet$DownPay());
        unmanagedCopy.realmSet$Cost(realmSource.realmGet$Cost());
        unmanagedCopy.realmSet$CashFlow(realmSource.realmGet$CashFlow());

        return unmanagedObject;
    }

    static com.cashFlowAuditor.Models.Business update(Realm realm, BusinessColumnInfo columnInfo, com.cashFlowAuditor.Models.Business realmObject, com.cashFlowAuditor.Models.Business newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_cashFlowAuditor_Models_BusinessRealmProxyInterface realmObjectTarget = (com_cashFlowAuditor_Models_BusinessRealmProxyInterface) realmObject;
        com_cashFlowAuditor_Models_BusinessRealmProxyInterface realmObjectSource = (com_cashFlowAuditor_Models_BusinessRealmProxyInterface) newObject;
        Table table = realm.getTable(com.cashFlowAuditor.Models.Business.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.NameIndex, realmObjectSource.realmGet$Name());
        builder.addInteger(columnInfo.DownPayIndex, realmObjectSource.realmGet$DownPay());
        builder.addInteger(columnInfo.CostIndex, realmObjectSource.realmGet$Cost());
        builder.addInteger(columnInfo.CashFlowIndex, realmObjectSource.realmGet$CashFlow());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Business = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Name:");
        stringBuilder.append(realmGet$Name() != null ? realmGet$Name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{DownPay:");
        stringBuilder.append(realmGet$DownPay());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Cost:");
        stringBuilder.append(realmGet$Cost());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{CashFlow:");
        stringBuilder.append(realmGet$CashFlow());
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
        com_cashFlowAuditor_Models_BusinessRealmProxy aBusiness = (com_cashFlowAuditor_Models_BusinessRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aBusiness.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aBusiness.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aBusiness.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
