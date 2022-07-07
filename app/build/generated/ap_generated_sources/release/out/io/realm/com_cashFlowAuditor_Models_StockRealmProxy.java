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
public class com_cashFlowAuditor_Models_StockRealmProxy extends com.cashFlowAuditor.Models.Stock
    implements RealmObjectProxy, com_cashFlowAuditor_Models_StockRealmProxyInterface {

    static final class StockColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idIndex;
        long NameIndex;
        long AmountIndex;
        long ValueIndex;

        StockColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Stock");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.NameIndex = addColumnDetails("Name", "Name", objectSchemaInfo);
            this.AmountIndex = addColumnDetails("Amount", "Amount", objectSchemaInfo);
            this.ValueIndex = addColumnDetails("Value", "Value", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        StockColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new StockColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final StockColumnInfo src = (StockColumnInfo) rawSrc;
            final StockColumnInfo dst = (StockColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.NameIndex = src.NameIndex;
            dst.AmountIndex = src.AmountIndex;
            dst.ValueIndex = src.ValueIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private StockColumnInfo columnInfo;
    private ProxyState<com.cashFlowAuditor.Models.Stock> proxyState;

    com_cashFlowAuditor_Models_StockRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (StockColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.cashFlowAuditor.Models.Stock>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(long value) {
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
                throw new IllegalArgumentException("Trying to set non-nullable field 'Name' to null.");
            }
            row.getTable().setString(columnInfo.NameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'Name' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.NameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$Amount() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.AmountIndex);
    }

    @Override
    public void realmSet$Amount(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.AmountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.AmountIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$Value() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.ValueIndex);
    }

    @Override
    public void realmSet$Value(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.ValueIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.ValueIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Stock", 4, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("Name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("Amount", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("Value", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static StockColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new StockColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Stock";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Stock";
    }

    @SuppressWarnings("cast")
    public static com.cashFlowAuditor.Models.Stock createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.cashFlowAuditor.Models.Stock obj = null;
        if (update) {
            Table table = realm.getTable(com.cashFlowAuditor.Models.Stock.class);
            StockColumnInfo columnInfo = (StockColumnInfo) realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.Stock.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.Stock.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_cashFlowAuditor_Models_StockRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_cashFlowAuditor_Models_StockRealmProxy) realm.createObjectInternal(com.cashFlowAuditor.Models.Stock.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_cashFlowAuditor_Models_StockRealmProxy) realm.createObjectInternal(com.cashFlowAuditor.Models.Stock.class, json.getLong("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_cashFlowAuditor_Models_StockRealmProxyInterface objProxy = (com_cashFlowAuditor_Models_StockRealmProxyInterface) obj;
        if (json.has("Name")) {
            if (json.isNull("Name")) {
                objProxy.realmSet$Name(null);
            } else {
                objProxy.realmSet$Name((String) json.getString("Name"));
            }
        }
        if (json.has("Amount")) {
            if (json.isNull("Amount")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'Amount' to null.");
            } else {
                objProxy.realmSet$Amount((int) json.getInt("Amount"));
            }
        }
        if (json.has("Value")) {
            if (json.isNull("Value")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'Value' to null.");
            } else {
                objProxy.realmSet$Value((int) json.getInt("Value"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.cashFlowAuditor.Models.Stock createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.cashFlowAuditor.Models.Stock obj = new com.cashFlowAuditor.Models.Stock();
        final com_cashFlowAuditor_Models_StockRealmProxyInterface objProxy = (com_cashFlowAuditor_Models_StockRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((long) reader.nextLong());
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
            } else if (name.equals("Amount")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Amount((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'Amount' to null.");
                }
            } else if (name.equals("Value")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Value((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'Value' to null.");
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

    private static com_cashFlowAuditor_Models_StockRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.Stock.class), false, Collections.<String>emptyList());
        io.realm.com_cashFlowAuditor_Models_StockRealmProxy obj = new io.realm.com_cashFlowAuditor_Models_StockRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.cashFlowAuditor.Models.Stock copyOrUpdate(Realm realm, StockColumnInfo columnInfo, com.cashFlowAuditor.Models.Stock object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.cashFlowAuditor.Models.Stock) cachedRealmObject;
        }

        com.cashFlowAuditor.Models.Stock realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.cashFlowAuditor.Models.Stock.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_cashFlowAuditor_Models_StockRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_cashFlowAuditor_Models_StockRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.cashFlowAuditor.Models.Stock copy(Realm realm, StockColumnInfo columnInfo, com.cashFlowAuditor.Models.Stock newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.cashFlowAuditor.Models.Stock) cachedRealmObject;
        }

        com_cashFlowAuditor_Models_StockRealmProxyInterface realmObjectSource = (com_cashFlowAuditor_Models_StockRealmProxyInterface) newObject;

        Table table = realm.getTable(com.cashFlowAuditor.Models.Stock.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.NameIndex, realmObjectSource.realmGet$Name());
        builder.addInteger(columnInfo.AmountIndex, realmObjectSource.realmGet$Amount());
        builder.addInteger(columnInfo.ValueIndex, realmObjectSource.realmGet$Value());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_cashFlowAuditor_Models_StockRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.cashFlowAuditor.Models.Stock object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.cashFlowAuditor.Models.Stock.class);
        long tableNativePtr = table.getNativePtr();
        StockColumnInfo columnInfo = (StockColumnInfo) realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.Stock.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_cashFlowAuditor_Models_StockRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_cashFlowAuditor_Models_StockRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_cashFlowAuditor_Models_StockRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$Name = ((com_cashFlowAuditor_Models_StockRealmProxyInterface) object).realmGet$Name();
        if (realmGet$Name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.NameIndex, rowIndex, realmGet$Name, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.AmountIndex, rowIndex, ((com_cashFlowAuditor_Models_StockRealmProxyInterface) object).realmGet$Amount(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.ValueIndex, rowIndex, ((com_cashFlowAuditor_Models_StockRealmProxyInterface) object).realmGet$Value(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.cashFlowAuditor.Models.Stock.class);
        long tableNativePtr = table.getNativePtr();
        StockColumnInfo columnInfo = (StockColumnInfo) realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.Stock.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.cashFlowAuditor.Models.Stock object = null;
        while (objects.hasNext()) {
            object = (com.cashFlowAuditor.Models.Stock) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_cashFlowAuditor_Models_StockRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_cashFlowAuditor_Models_StockRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_cashFlowAuditor_Models_StockRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$Name = ((com_cashFlowAuditor_Models_StockRealmProxyInterface) object).realmGet$Name();
            if (realmGet$Name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.NameIndex, rowIndex, realmGet$Name, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.AmountIndex, rowIndex, ((com_cashFlowAuditor_Models_StockRealmProxyInterface) object).realmGet$Amount(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.ValueIndex, rowIndex, ((com_cashFlowAuditor_Models_StockRealmProxyInterface) object).realmGet$Value(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.cashFlowAuditor.Models.Stock object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.cashFlowAuditor.Models.Stock.class);
        long tableNativePtr = table.getNativePtr();
        StockColumnInfo columnInfo = (StockColumnInfo) realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.Stock.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_cashFlowAuditor_Models_StockRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_cashFlowAuditor_Models_StockRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_cashFlowAuditor_Models_StockRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$Name = ((com_cashFlowAuditor_Models_StockRealmProxyInterface) object).realmGet$Name();
        if (realmGet$Name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.NameIndex, rowIndex, realmGet$Name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.NameIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.AmountIndex, rowIndex, ((com_cashFlowAuditor_Models_StockRealmProxyInterface) object).realmGet$Amount(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.ValueIndex, rowIndex, ((com_cashFlowAuditor_Models_StockRealmProxyInterface) object).realmGet$Value(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.cashFlowAuditor.Models.Stock.class);
        long tableNativePtr = table.getNativePtr();
        StockColumnInfo columnInfo = (StockColumnInfo) realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.Stock.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.cashFlowAuditor.Models.Stock object = null;
        while (objects.hasNext()) {
            object = (com.cashFlowAuditor.Models.Stock) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_cashFlowAuditor_Models_StockRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_cashFlowAuditor_Models_StockRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_cashFlowAuditor_Models_StockRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            String realmGet$Name = ((com_cashFlowAuditor_Models_StockRealmProxyInterface) object).realmGet$Name();
            if (realmGet$Name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.NameIndex, rowIndex, realmGet$Name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.NameIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.AmountIndex, rowIndex, ((com_cashFlowAuditor_Models_StockRealmProxyInterface) object).realmGet$Amount(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.ValueIndex, rowIndex, ((com_cashFlowAuditor_Models_StockRealmProxyInterface) object).realmGet$Value(), false);
        }
    }

    public static com.cashFlowAuditor.Models.Stock createDetachedCopy(com.cashFlowAuditor.Models.Stock realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.cashFlowAuditor.Models.Stock unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.cashFlowAuditor.Models.Stock();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.cashFlowAuditor.Models.Stock) cachedObject.object;
            }
            unmanagedObject = (com.cashFlowAuditor.Models.Stock) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_cashFlowAuditor_Models_StockRealmProxyInterface unmanagedCopy = (com_cashFlowAuditor_Models_StockRealmProxyInterface) unmanagedObject;
        com_cashFlowAuditor_Models_StockRealmProxyInterface realmSource = (com_cashFlowAuditor_Models_StockRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$Name(realmSource.realmGet$Name());
        unmanagedCopy.realmSet$Amount(realmSource.realmGet$Amount());
        unmanagedCopy.realmSet$Value(realmSource.realmGet$Value());

        return unmanagedObject;
    }

    static com.cashFlowAuditor.Models.Stock update(Realm realm, StockColumnInfo columnInfo, com.cashFlowAuditor.Models.Stock realmObject, com.cashFlowAuditor.Models.Stock newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_cashFlowAuditor_Models_StockRealmProxyInterface realmObjectTarget = (com_cashFlowAuditor_Models_StockRealmProxyInterface) realmObject;
        com_cashFlowAuditor_Models_StockRealmProxyInterface realmObjectSource = (com_cashFlowAuditor_Models_StockRealmProxyInterface) newObject;
        Table table = realm.getTable(com.cashFlowAuditor.Models.Stock.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.NameIndex, realmObjectSource.realmGet$Name());
        builder.addInteger(columnInfo.AmountIndex, realmObjectSource.realmGet$Amount());
        builder.addInteger(columnInfo.ValueIndex, realmObjectSource.realmGet$Value());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Stock = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Name:");
        stringBuilder.append(realmGet$Name());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Amount:");
        stringBuilder.append(realmGet$Amount());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Value:");
        stringBuilder.append(realmGet$Value());
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
        com_cashFlowAuditor_Models_StockRealmProxy aStock = (com_cashFlowAuditor_Models_StockRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aStock.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aStock.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aStock.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
