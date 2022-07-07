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
public class com_cashFlowAuditor_Models_ProfessionRealmProxy extends com.cashFlowAuditor.Models.Profession
    implements RealmObjectProxy, com_cashFlowAuditor_Models_ProfessionRealmProxyInterface {

    static final class ProfessionColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idIndex;
        long DescriptionIndex;
        long SalaryIndex;
        long TaxesIndex;
        long HomeMortgagePaymentIndex;
        long SchoolLoanPaymentIndex;
        long CarLoanPaymentIndex;
        long CreditCardPaymentIndex;
        long RetailPaymentIndex;
        long HomeMortgageIndex;
        long HomeMortgagePaidIndex;
        long SchoolLoanIndex;
        long SchoolLoanPaidIndex;
        long CarLoanIndex;
        long CarLoanPaidIndex;
        long CreditCardIndex;
        long CreditCardPaidIndex;
        long RetailDebtIndex;
        long RetailDebtPaidIndex;
        long PerChildExpenseIndex;
        long ChildNumberIndex;
        long OtherExpensesIndex;
        long SavingsIndex;
        long SelectedIndex;
        long LoanIndex;

        ProfessionColumnInfo(OsSchemaInfo schemaInfo) {
            super(25);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Profession");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.DescriptionIndex = addColumnDetails("Description", "Description", objectSchemaInfo);
            this.SalaryIndex = addColumnDetails("Salary", "Salary", objectSchemaInfo);
            this.TaxesIndex = addColumnDetails("Taxes", "Taxes", objectSchemaInfo);
            this.HomeMortgagePaymentIndex = addColumnDetails("HomeMortgagePayment", "HomeMortgagePayment", objectSchemaInfo);
            this.SchoolLoanPaymentIndex = addColumnDetails("SchoolLoanPayment", "SchoolLoanPayment", objectSchemaInfo);
            this.CarLoanPaymentIndex = addColumnDetails("CarLoanPayment", "CarLoanPayment", objectSchemaInfo);
            this.CreditCardPaymentIndex = addColumnDetails("CreditCardPayment", "CreditCardPayment", objectSchemaInfo);
            this.RetailPaymentIndex = addColumnDetails("RetailPayment", "RetailPayment", objectSchemaInfo);
            this.HomeMortgageIndex = addColumnDetails("HomeMortgage", "HomeMortgage", objectSchemaInfo);
            this.HomeMortgagePaidIndex = addColumnDetails("HomeMortgagePaid", "HomeMortgagePaid", objectSchemaInfo);
            this.SchoolLoanIndex = addColumnDetails("SchoolLoan", "SchoolLoan", objectSchemaInfo);
            this.SchoolLoanPaidIndex = addColumnDetails("SchoolLoanPaid", "SchoolLoanPaid", objectSchemaInfo);
            this.CarLoanIndex = addColumnDetails("CarLoan", "CarLoan", objectSchemaInfo);
            this.CarLoanPaidIndex = addColumnDetails("CarLoanPaid", "CarLoanPaid", objectSchemaInfo);
            this.CreditCardIndex = addColumnDetails("CreditCard", "CreditCard", objectSchemaInfo);
            this.CreditCardPaidIndex = addColumnDetails("CreditCardPaid", "CreditCardPaid", objectSchemaInfo);
            this.RetailDebtIndex = addColumnDetails("RetailDebt", "RetailDebt", objectSchemaInfo);
            this.RetailDebtPaidIndex = addColumnDetails("RetailDebtPaid", "RetailDebtPaid", objectSchemaInfo);
            this.PerChildExpenseIndex = addColumnDetails("PerChildExpense", "PerChildExpense", objectSchemaInfo);
            this.ChildNumberIndex = addColumnDetails("ChildNumber", "ChildNumber", objectSchemaInfo);
            this.OtherExpensesIndex = addColumnDetails("OtherExpenses", "OtherExpenses", objectSchemaInfo);
            this.SavingsIndex = addColumnDetails("Savings", "Savings", objectSchemaInfo);
            this.SelectedIndex = addColumnDetails("Selected", "Selected", objectSchemaInfo);
            this.LoanIndex = addColumnDetails("Loan", "Loan", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        ProfessionColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ProfessionColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ProfessionColumnInfo src = (ProfessionColumnInfo) rawSrc;
            final ProfessionColumnInfo dst = (ProfessionColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.DescriptionIndex = src.DescriptionIndex;
            dst.SalaryIndex = src.SalaryIndex;
            dst.TaxesIndex = src.TaxesIndex;
            dst.HomeMortgagePaymentIndex = src.HomeMortgagePaymentIndex;
            dst.SchoolLoanPaymentIndex = src.SchoolLoanPaymentIndex;
            dst.CarLoanPaymentIndex = src.CarLoanPaymentIndex;
            dst.CreditCardPaymentIndex = src.CreditCardPaymentIndex;
            dst.RetailPaymentIndex = src.RetailPaymentIndex;
            dst.HomeMortgageIndex = src.HomeMortgageIndex;
            dst.HomeMortgagePaidIndex = src.HomeMortgagePaidIndex;
            dst.SchoolLoanIndex = src.SchoolLoanIndex;
            dst.SchoolLoanPaidIndex = src.SchoolLoanPaidIndex;
            dst.CarLoanIndex = src.CarLoanIndex;
            dst.CarLoanPaidIndex = src.CarLoanPaidIndex;
            dst.CreditCardIndex = src.CreditCardIndex;
            dst.CreditCardPaidIndex = src.CreditCardPaidIndex;
            dst.RetailDebtIndex = src.RetailDebtIndex;
            dst.RetailDebtPaidIndex = src.RetailDebtPaidIndex;
            dst.PerChildExpenseIndex = src.PerChildExpenseIndex;
            dst.ChildNumberIndex = src.ChildNumberIndex;
            dst.OtherExpensesIndex = src.OtherExpensesIndex;
            dst.SavingsIndex = src.SavingsIndex;
            dst.SelectedIndex = src.SelectedIndex;
            dst.LoanIndex = src.LoanIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ProfessionColumnInfo columnInfo;
    private ProxyState<com.cashFlowAuditor.Models.Profession> proxyState;

    com_cashFlowAuditor_Models_ProfessionRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ProfessionColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.cashFlowAuditor.Models.Profession>(this);
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
    public String realmGet$Description() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.DescriptionIndex);
    }

    @Override
    public void realmSet$Description(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.DescriptionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.DescriptionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.DescriptionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.DescriptionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$Salary() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.SalaryIndex);
    }

    @Override
    public void realmSet$Salary(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.SalaryIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.SalaryIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$Taxes() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.TaxesIndex);
    }

    @Override
    public void realmSet$Taxes(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.TaxesIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.TaxesIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$HomeMortgagePayment() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.HomeMortgagePaymentIndex);
    }

    @Override
    public void realmSet$HomeMortgagePayment(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.HomeMortgagePaymentIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.HomeMortgagePaymentIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$SchoolLoanPayment() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.SchoolLoanPaymentIndex);
    }

    @Override
    public void realmSet$SchoolLoanPayment(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.SchoolLoanPaymentIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.SchoolLoanPaymentIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$CarLoanPayment() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.CarLoanPaymentIndex);
    }

    @Override
    public void realmSet$CarLoanPayment(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.CarLoanPaymentIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.CarLoanPaymentIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$CreditCardPayment() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.CreditCardPaymentIndex);
    }

    @Override
    public void realmSet$CreditCardPayment(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.CreditCardPaymentIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.CreditCardPaymentIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$RetailPayment() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.RetailPaymentIndex);
    }

    @Override
    public void realmSet$RetailPayment(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.RetailPaymentIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.RetailPaymentIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$HomeMortgage() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.HomeMortgageIndex);
    }

    @Override
    public void realmSet$HomeMortgage(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.HomeMortgageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.HomeMortgageIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$HomeMortgagePaid() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.HomeMortgagePaidIndex);
    }

    @Override
    public void realmSet$HomeMortgagePaid(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.HomeMortgagePaidIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.HomeMortgagePaidIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$SchoolLoan() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.SchoolLoanIndex);
    }

    @Override
    public void realmSet$SchoolLoan(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.SchoolLoanIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.SchoolLoanIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$SchoolLoanPaid() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.SchoolLoanPaidIndex);
    }

    @Override
    public void realmSet$SchoolLoanPaid(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.SchoolLoanPaidIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.SchoolLoanPaidIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$CarLoan() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.CarLoanIndex);
    }

    @Override
    public void realmSet$CarLoan(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.CarLoanIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.CarLoanIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$CarLoanPaid() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.CarLoanPaidIndex);
    }

    @Override
    public void realmSet$CarLoanPaid(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.CarLoanPaidIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.CarLoanPaidIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$CreditCard() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.CreditCardIndex);
    }

    @Override
    public void realmSet$CreditCard(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.CreditCardIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.CreditCardIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$CreditCardPaid() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.CreditCardPaidIndex);
    }

    @Override
    public void realmSet$CreditCardPaid(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.CreditCardPaidIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.CreditCardPaidIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$RetailDebt() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.RetailDebtIndex);
    }

    @Override
    public void realmSet$RetailDebt(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.RetailDebtIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.RetailDebtIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$RetailDebtPaid() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.RetailDebtPaidIndex);
    }

    @Override
    public void realmSet$RetailDebtPaid(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.RetailDebtPaidIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.RetailDebtPaidIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$PerChildExpense() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.PerChildExpenseIndex);
    }

    @Override
    public void realmSet$PerChildExpense(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.PerChildExpenseIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.PerChildExpenseIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$ChildNumber() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.ChildNumberIndex);
    }

    @Override
    public void realmSet$ChildNumber(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.ChildNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.ChildNumberIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$OtherExpenses() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.OtherExpensesIndex);
    }

    @Override
    public void realmSet$OtherExpenses(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.OtherExpensesIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.OtherExpensesIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$Savings() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.SavingsIndex);
    }

    @Override
    public void realmSet$Savings(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.SavingsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.SavingsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$Selected() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.SelectedIndex);
    }

    @Override
    public void realmSet$Selected(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.SelectedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.SelectedIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$Loan() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.LoanIndex);
    }

    @Override
    public void realmSet$Loan(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.LoanIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.LoanIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Profession", 25, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("Description", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Salary", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("Taxes", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("HomeMortgagePayment", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("SchoolLoanPayment", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("CarLoanPayment", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("CreditCardPayment", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("RetailPayment", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("HomeMortgage", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("HomeMortgagePaid", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("SchoolLoan", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("SchoolLoanPaid", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("CarLoan", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("CarLoanPaid", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("CreditCard", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("CreditCardPaid", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("RetailDebt", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("RetailDebtPaid", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("PerChildExpense", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("ChildNumber", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("OtherExpenses", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("Savings", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("Selected", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("Loan", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ProfessionColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ProfessionColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Profession";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Profession";
    }

    @SuppressWarnings("cast")
    public static com.cashFlowAuditor.Models.Profession createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.cashFlowAuditor.Models.Profession obj = null;
        if (update) {
            Table table = realm.getTable(com.cashFlowAuditor.Models.Profession.class);
            ProfessionColumnInfo columnInfo = (ProfessionColumnInfo) realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.Profession.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.Profession.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_cashFlowAuditor_Models_ProfessionRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_cashFlowAuditor_Models_ProfessionRealmProxy) realm.createObjectInternal(com.cashFlowAuditor.Models.Profession.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_cashFlowAuditor_Models_ProfessionRealmProxy) realm.createObjectInternal(com.cashFlowAuditor.Models.Profession.class, json.getLong("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_cashFlowAuditor_Models_ProfessionRealmProxyInterface objProxy = (com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) obj;
        if (json.has("Description")) {
            if (json.isNull("Description")) {
                objProxy.realmSet$Description(null);
            } else {
                objProxy.realmSet$Description((String) json.getString("Description"));
            }
        }
        if (json.has("Salary")) {
            if (json.isNull("Salary")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'Salary' to null.");
            } else {
                objProxy.realmSet$Salary((int) json.getInt("Salary"));
            }
        }
        if (json.has("Taxes")) {
            if (json.isNull("Taxes")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'Taxes' to null.");
            } else {
                objProxy.realmSet$Taxes((int) json.getInt("Taxes"));
            }
        }
        if (json.has("HomeMortgagePayment")) {
            if (json.isNull("HomeMortgagePayment")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'HomeMortgagePayment' to null.");
            } else {
                objProxy.realmSet$HomeMortgagePayment((int) json.getInt("HomeMortgagePayment"));
            }
        }
        if (json.has("SchoolLoanPayment")) {
            if (json.isNull("SchoolLoanPayment")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'SchoolLoanPayment' to null.");
            } else {
                objProxy.realmSet$SchoolLoanPayment((int) json.getInt("SchoolLoanPayment"));
            }
        }
        if (json.has("CarLoanPayment")) {
            if (json.isNull("CarLoanPayment")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'CarLoanPayment' to null.");
            } else {
                objProxy.realmSet$CarLoanPayment((int) json.getInt("CarLoanPayment"));
            }
        }
        if (json.has("CreditCardPayment")) {
            if (json.isNull("CreditCardPayment")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'CreditCardPayment' to null.");
            } else {
                objProxy.realmSet$CreditCardPayment((int) json.getInt("CreditCardPayment"));
            }
        }
        if (json.has("RetailPayment")) {
            if (json.isNull("RetailPayment")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'RetailPayment' to null.");
            } else {
                objProxy.realmSet$RetailPayment((int) json.getInt("RetailPayment"));
            }
        }
        if (json.has("HomeMortgage")) {
            if (json.isNull("HomeMortgage")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'HomeMortgage' to null.");
            } else {
                objProxy.realmSet$HomeMortgage((int) json.getInt("HomeMortgage"));
            }
        }
        if (json.has("HomeMortgagePaid")) {
            if (json.isNull("HomeMortgagePaid")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'HomeMortgagePaid' to null.");
            } else {
                objProxy.realmSet$HomeMortgagePaid((boolean) json.getBoolean("HomeMortgagePaid"));
            }
        }
        if (json.has("SchoolLoan")) {
            if (json.isNull("SchoolLoan")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'SchoolLoan' to null.");
            } else {
                objProxy.realmSet$SchoolLoan((int) json.getInt("SchoolLoan"));
            }
        }
        if (json.has("SchoolLoanPaid")) {
            if (json.isNull("SchoolLoanPaid")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'SchoolLoanPaid' to null.");
            } else {
                objProxy.realmSet$SchoolLoanPaid((boolean) json.getBoolean("SchoolLoanPaid"));
            }
        }
        if (json.has("CarLoan")) {
            if (json.isNull("CarLoan")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'CarLoan' to null.");
            } else {
                objProxy.realmSet$CarLoan((int) json.getInt("CarLoan"));
            }
        }
        if (json.has("CarLoanPaid")) {
            if (json.isNull("CarLoanPaid")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'CarLoanPaid' to null.");
            } else {
                objProxy.realmSet$CarLoanPaid((boolean) json.getBoolean("CarLoanPaid"));
            }
        }
        if (json.has("CreditCard")) {
            if (json.isNull("CreditCard")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'CreditCard' to null.");
            } else {
                objProxy.realmSet$CreditCard((int) json.getInt("CreditCard"));
            }
        }
        if (json.has("CreditCardPaid")) {
            if (json.isNull("CreditCardPaid")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'CreditCardPaid' to null.");
            } else {
                objProxy.realmSet$CreditCardPaid((boolean) json.getBoolean("CreditCardPaid"));
            }
        }
        if (json.has("RetailDebt")) {
            if (json.isNull("RetailDebt")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'RetailDebt' to null.");
            } else {
                objProxy.realmSet$RetailDebt((int) json.getInt("RetailDebt"));
            }
        }
        if (json.has("RetailDebtPaid")) {
            if (json.isNull("RetailDebtPaid")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'RetailDebtPaid' to null.");
            } else {
                objProxy.realmSet$RetailDebtPaid((boolean) json.getBoolean("RetailDebtPaid"));
            }
        }
        if (json.has("PerChildExpense")) {
            if (json.isNull("PerChildExpense")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'PerChildExpense' to null.");
            } else {
                objProxy.realmSet$PerChildExpense((int) json.getInt("PerChildExpense"));
            }
        }
        if (json.has("ChildNumber")) {
            if (json.isNull("ChildNumber")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'ChildNumber' to null.");
            } else {
                objProxy.realmSet$ChildNumber((int) json.getInt("ChildNumber"));
            }
        }
        if (json.has("OtherExpenses")) {
            if (json.isNull("OtherExpenses")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'OtherExpenses' to null.");
            } else {
                objProxy.realmSet$OtherExpenses((int) json.getInt("OtherExpenses"));
            }
        }
        if (json.has("Savings")) {
            if (json.isNull("Savings")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'Savings' to null.");
            } else {
                objProxy.realmSet$Savings((int) json.getInt("Savings"));
            }
        }
        if (json.has("Selected")) {
            if (json.isNull("Selected")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'Selected' to null.");
            } else {
                objProxy.realmSet$Selected((boolean) json.getBoolean("Selected"));
            }
        }
        if (json.has("Loan")) {
            if (json.isNull("Loan")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'Loan' to null.");
            } else {
                objProxy.realmSet$Loan((int) json.getInt("Loan"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.cashFlowAuditor.Models.Profession createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.cashFlowAuditor.Models.Profession obj = new com.cashFlowAuditor.Models.Profession();
        final com_cashFlowAuditor_Models_ProfessionRealmProxyInterface objProxy = (com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) obj;
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
            } else if (name.equals("Description")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Description((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Description(null);
                }
            } else if (name.equals("Salary")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Salary((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'Salary' to null.");
                }
            } else if (name.equals("Taxes")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Taxes((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'Taxes' to null.");
                }
            } else if (name.equals("HomeMortgagePayment")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$HomeMortgagePayment((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'HomeMortgagePayment' to null.");
                }
            } else if (name.equals("SchoolLoanPayment")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$SchoolLoanPayment((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'SchoolLoanPayment' to null.");
                }
            } else if (name.equals("CarLoanPayment")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$CarLoanPayment((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'CarLoanPayment' to null.");
                }
            } else if (name.equals("CreditCardPayment")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$CreditCardPayment((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'CreditCardPayment' to null.");
                }
            } else if (name.equals("RetailPayment")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$RetailPayment((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'RetailPayment' to null.");
                }
            } else if (name.equals("HomeMortgage")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$HomeMortgage((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'HomeMortgage' to null.");
                }
            } else if (name.equals("HomeMortgagePaid")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$HomeMortgagePaid((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'HomeMortgagePaid' to null.");
                }
            } else if (name.equals("SchoolLoan")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$SchoolLoan((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'SchoolLoan' to null.");
                }
            } else if (name.equals("SchoolLoanPaid")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$SchoolLoanPaid((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'SchoolLoanPaid' to null.");
                }
            } else if (name.equals("CarLoan")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$CarLoan((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'CarLoan' to null.");
                }
            } else if (name.equals("CarLoanPaid")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$CarLoanPaid((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'CarLoanPaid' to null.");
                }
            } else if (name.equals("CreditCard")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$CreditCard((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'CreditCard' to null.");
                }
            } else if (name.equals("CreditCardPaid")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$CreditCardPaid((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'CreditCardPaid' to null.");
                }
            } else if (name.equals("RetailDebt")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$RetailDebt((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'RetailDebt' to null.");
                }
            } else if (name.equals("RetailDebtPaid")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$RetailDebtPaid((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'RetailDebtPaid' to null.");
                }
            } else if (name.equals("PerChildExpense")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$PerChildExpense((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'PerChildExpense' to null.");
                }
            } else if (name.equals("ChildNumber")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$ChildNumber((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'ChildNumber' to null.");
                }
            } else if (name.equals("OtherExpenses")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$OtherExpenses((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'OtherExpenses' to null.");
                }
            } else if (name.equals("Savings")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Savings((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'Savings' to null.");
                }
            } else if (name.equals("Selected")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Selected((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'Selected' to null.");
                }
            } else if (name.equals("Loan")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Loan((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'Loan' to null.");
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

    private static com_cashFlowAuditor_Models_ProfessionRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.Profession.class), false, Collections.<String>emptyList());
        io.realm.com_cashFlowAuditor_Models_ProfessionRealmProxy obj = new io.realm.com_cashFlowAuditor_Models_ProfessionRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.cashFlowAuditor.Models.Profession copyOrUpdate(Realm realm, ProfessionColumnInfo columnInfo, com.cashFlowAuditor.Models.Profession object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.cashFlowAuditor.Models.Profession) cachedRealmObject;
        }

        com.cashFlowAuditor.Models.Profession realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.cashFlowAuditor.Models.Profession.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_cashFlowAuditor_Models_ProfessionRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.cashFlowAuditor.Models.Profession copy(Realm realm, ProfessionColumnInfo columnInfo, com.cashFlowAuditor.Models.Profession newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.cashFlowAuditor.Models.Profession) cachedRealmObject;
        }

        com_cashFlowAuditor_Models_ProfessionRealmProxyInterface realmObjectSource = (com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) newObject;

        Table table = realm.getTable(com.cashFlowAuditor.Models.Profession.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.DescriptionIndex, realmObjectSource.realmGet$Description());
        builder.addInteger(columnInfo.SalaryIndex, realmObjectSource.realmGet$Salary());
        builder.addInteger(columnInfo.TaxesIndex, realmObjectSource.realmGet$Taxes());
        builder.addInteger(columnInfo.HomeMortgagePaymentIndex, realmObjectSource.realmGet$HomeMortgagePayment());
        builder.addInteger(columnInfo.SchoolLoanPaymentIndex, realmObjectSource.realmGet$SchoolLoanPayment());
        builder.addInteger(columnInfo.CarLoanPaymentIndex, realmObjectSource.realmGet$CarLoanPayment());
        builder.addInteger(columnInfo.CreditCardPaymentIndex, realmObjectSource.realmGet$CreditCardPayment());
        builder.addInteger(columnInfo.RetailPaymentIndex, realmObjectSource.realmGet$RetailPayment());
        builder.addInteger(columnInfo.HomeMortgageIndex, realmObjectSource.realmGet$HomeMortgage());
        builder.addBoolean(columnInfo.HomeMortgagePaidIndex, realmObjectSource.realmGet$HomeMortgagePaid());
        builder.addInteger(columnInfo.SchoolLoanIndex, realmObjectSource.realmGet$SchoolLoan());
        builder.addBoolean(columnInfo.SchoolLoanPaidIndex, realmObjectSource.realmGet$SchoolLoanPaid());
        builder.addInteger(columnInfo.CarLoanIndex, realmObjectSource.realmGet$CarLoan());
        builder.addBoolean(columnInfo.CarLoanPaidIndex, realmObjectSource.realmGet$CarLoanPaid());
        builder.addInteger(columnInfo.CreditCardIndex, realmObjectSource.realmGet$CreditCard());
        builder.addBoolean(columnInfo.CreditCardPaidIndex, realmObjectSource.realmGet$CreditCardPaid());
        builder.addInteger(columnInfo.RetailDebtIndex, realmObjectSource.realmGet$RetailDebt());
        builder.addBoolean(columnInfo.RetailDebtPaidIndex, realmObjectSource.realmGet$RetailDebtPaid());
        builder.addInteger(columnInfo.PerChildExpenseIndex, realmObjectSource.realmGet$PerChildExpense());
        builder.addInteger(columnInfo.ChildNumberIndex, realmObjectSource.realmGet$ChildNumber());
        builder.addInteger(columnInfo.OtherExpensesIndex, realmObjectSource.realmGet$OtherExpenses());
        builder.addInteger(columnInfo.SavingsIndex, realmObjectSource.realmGet$Savings());
        builder.addBoolean(columnInfo.SelectedIndex, realmObjectSource.realmGet$Selected());
        builder.addInteger(columnInfo.LoanIndex, realmObjectSource.realmGet$Loan());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_cashFlowAuditor_Models_ProfessionRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.cashFlowAuditor.Models.Profession object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.cashFlowAuditor.Models.Profession.class);
        long tableNativePtr = table.getNativePtr();
        ProfessionColumnInfo columnInfo = (ProfessionColumnInfo) realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.Profession.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$Description = ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$Description();
        if (realmGet$Description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.DescriptionIndex, rowIndex, realmGet$Description, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.SalaryIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$Salary(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.TaxesIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$Taxes(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.HomeMortgagePaymentIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$HomeMortgagePayment(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.SchoolLoanPaymentIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$SchoolLoanPayment(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.CarLoanPaymentIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$CarLoanPayment(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.CreditCardPaymentIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$CreditCardPayment(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.RetailPaymentIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$RetailPayment(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.HomeMortgageIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$HomeMortgage(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.HomeMortgagePaidIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$HomeMortgagePaid(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.SchoolLoanIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$SchoolLoan(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.SchoolLoanPaidIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$SchoolLoanPaid(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.CarLoanIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$CarLoan(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.CarLoanPaidIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$CarLoanPaid(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.CreditCardIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$CreditCard(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.CreditCardPaidIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$CreditCardPaid(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.RetailDebtIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$RetailDebt(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.RetailDebtPaidIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$RetailDebtPaid(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.PerChildExpenseIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$PerChildExpense(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.ChildNumberIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$ChildNumber(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.OtherExpensesIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$OtherExpenses(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.SavingsIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$Savings(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.SelectedIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$Selected(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.LoanIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$Loan(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.cashFlowAuditor.Models.Profession.class);
        long tableNativePtr = table.getNativePtr();
        ProfessionColumnInfo columnInfo = (ProfessionColumnInfo) realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.Profession.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.cashFlowAuditor.Models.Profession object = null;
        while (objects.hasNext()) {
            object = (com.cashFlowAuditor.Models.Profession) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$Description = ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$Description();
            if (realmGet$Description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.DescriptionIndex, rowIndex, realmGet$Description, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.SalaryIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$Salary(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.TaxesIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$Taxes(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.HomeMortgagePaymentIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$HomeMortgagePayment(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.SchoolLoanPaymentIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$SchoolLoanPayment(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.CarLoanPaymentIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$CarLoanPayment(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.CreditCardPaymentIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$CreditCardPayment(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.RetailPaymentIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$RetailPayment(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.HomeMortgageIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$HomeMortgage(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.HomeMortgagePaidIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$HomeMortgagePaid(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.SchoolLoanIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$SchoolLoan(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.SchoolLoanPaidIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$SchoolLoanPaid(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.CarLoanIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$CarLoan(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.CarLoanPaidIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$CarLoanPaid(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.CreditCardIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$CreditCard(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.CreditCardPaidIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$CreditCardPaid(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.RetailDebtIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$RetailDebt(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.RetailDebtPaidIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$RetailDebtPaid(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.PerChildExpenseIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$PerChildExpense(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.ChildNumberIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$ChildNumber(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.OtherExpensesIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$OtherExpenses(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.SavingsIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$Savings(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.SelectedIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$Selected(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.LoanIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$Loan(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.cashFlowAuditor.Models.Profession object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.cashFlowAuditor.Models.Profession.class);
        long tableNativePtr = table.getNativePtr();
        ProfessionColumnInfo columnInfo = (ProfessionColumnInfo) realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.Profession.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$Description = ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$Description();
        if (realmGet$Description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.DescriptionIndex, rowIndex, realmGet$Description, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.DescriptionIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.SalaryIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$Salary(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.TaxesIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$Taxes(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.HomeMortgagePaymentIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$HomeMortgagePayment(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.SchoolLoanPaymentIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$SchoolLoanPayment(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.CarLoanPaymentIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$CarLoanPayment(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.CreditCardPaymentIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$CreditCardPayment(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.RetailPaymentIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$RetailPayment(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.HomeMortgageIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$HomeMortgage(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.HomeMortgagePaidIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$HomeMortgagePaid(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.SchoolLoanIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$SchoolLoan(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.SchoolLoanPaidIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$SchoolLoanPaid(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.CarLoanIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$CarLoan(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.CarLoanPaidIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$CarLoanPaid(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.CreditCardIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$CreditCard(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.CreditCardPaidIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$CreditCardPaid(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.RetailDebtIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$RetailDebt(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.RetailDebtPaidIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$RetailDebtPaid(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.PerChildExpenseIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$PerChildExpense(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.ChildNumberIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$ChildNumber(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.OtherExpensesIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$OtherExpenses(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.SavingsIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$Savings(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.SelectedIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$Selected(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.LoanIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$Loan(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.cashFlowAuditor.Models.Profession.class);
        long tableNativePtr = table.getNativePtr();
        ProfessionColumnInfo columnInfo = (ProfessionColumnInfo) realm.getSchema().getColumnInfo(com.cashFlowAuditor.Models.Profession.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.cashFlowAuditor.Models.Profession object = null;
        while (objects.hasNext()) {
            object = (com.cashFlowAuditor.Models.Profession) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            String realmGet$Description = ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$Description();
            if (realmGet$Description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.DescriptionIndex, rowIndex, realmGet$Description, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.DescriptionIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.SalaryIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$Salary(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.TaxesIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$Taxes(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.HomeMortgagePaymentIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$HomeMortgagePayment(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.SchoolLoanPaymentIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$SchoolLoanPayment(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.CarLoanPaymentIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$CarLoanPayment(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.CreditCardPaymentIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$CreditCardPayment(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.RetailPaymentIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$RetailPayment(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.HomeMortgageIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$HomeMortgage(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.HomeMortgagePaidIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$HomeMortgagePaid(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.SchoolLoanIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$SchoolLoan(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.SchoolLoanPaidIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$SchoolLoanPaid(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.CarLoanIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$CarLoan(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.CarLoanPaidIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$CarLoanPaid(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.CreditCardIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$CreditCard(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.CreditCardPaidIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$CreditCardPaid(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.RetailDebtIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$RetailDebt(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.RetailDebtPaidIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$RetailDebtPaid(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.PerChildExpenseIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$PerChildExpense(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.ChildNumberIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$ChildNumber(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.OtherExpensesIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$OtherExpenses(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.SavingsIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$Savings(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.SelectedIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$Selected(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.LoanIndex, rowIndex, ((com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) object).realmGet$Loan(), false);
        }
    }

    public static com.cashFlowAuditor.Models.Profession createDetachedCopy(com.cashFlowAuditor.Models.Profession realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.cashFlowAuditor.Models.Profession unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.cashFlowAuditor.Models.Profession();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.cashFlowAuditor.Models.Profession) cachedObject.object;
            }
            unmanagedObject = (com.cashFlowAuditor.Models.Profession) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_cashFlowAuditor_Models_ProfessionRealmProxyInterface unmanagedCopy = (com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) unmanagedObject;
        com_cashFlowAuditor_Models_ProfessionRealmProxyInterface realmSource = (com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$Description(realmSource.realmGet$Description());
        unmanagedCopy.realmSet$Salary(realmSource.realmGet$Salary());
        unmanagedCopy.realmSet$Taxes(realmSource.realmGet$Taxes());
        unmanagedCopy.realmSet$HomeMortgagePayment(realmSource.realmGet$HomeMortgagePayment());
        unmanagedCopy.realmSet$SchoolLoanPayment(realmSource.realmGet$SchoolLoanPayment());
        unmanagedCopy.realmSet$CarLoanPayment(realmSource.realmGet$CarLoanPayment());
        unmanagedCopy.realmSet$CreditCardPayment(realmSource.realmGet$CreditCardPayment());
        unmanagedCopy.realmSet$RetailPayment(realmSource.realmGet$RetailPayment());
        unmanagedCopy.realmSet$HomeMortgage(realmSource.realmGet$HomeMortgage());
        unmanagedCopy.realmSet$HomeMortgagePaid(realmSource.realmGet$HomeMortgagePaid());
        unmanagedCopy.realmSet$SchoolLoan(realmSource.realmGet$SchoolLoan());
        unmanagedCopy.realmSet$SchoolLoanPaid(realmSource.realmGet$SchoolLoanPaid());
        unmanagedCopy.realmSet$CarLoan(realmSource.realmGet$CarLoan());
        unmanagedCopy.realmSet$CarLoanPaid(realmSource.realmGet$CarLoanPaid());
        unmanagedCopy.realmSet$CreditCard(realmSource.realmGet$CreditCard());
        unmanagedCopy.realmSet$CreditCardPaid(realmSource.realmGet$CreditCardPaid());
        unmanagedCopy.realmSet$RetailDebt(realmSource.realmGet$RetailDebt());
        unmanagedCopy.realmSet$RetailDebtPaid(realmSource.realmGet$RetailDebtPaid());
        unmanagedCopy.realmSet$PerChildExpense(realmSource.realmGet$PerChildExpense());
        unmanagedCopy.realmSet$ChildNumber(realmSource.realmGet$ChildNumber());
        unmanagedCopy.realmSet$OtherExpenses(realmSource.realmGet$OtherExpenses());
        unmanagedCopy.realmSet$Savings(realmSource.realmGet$Savings());
        unmanagedCopy.realmSet$Selected(realmSource.realmGet$Selected());
        unmanagedCopy.realmSet$Loan(realmSource.realmGet$Loan());

        return unmanagedObject;
    }

    static com.cashFlowAuditor.Models.Profession update(Realm realm, ProfessionColumnInfo columnInfo, com.cashFlowAuditor.Models.Profession realmObject, com.cashFlowAuditor.Models.Profession newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_cashFlowAuditor_Models_ProfessionRealmProxyInterface realmObjectTarget = (com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) realmObject;
        com_cashFlowAuditor_Models_ProfessionRealmProxyInterface realmObjectSource = (com_cashFlowAuditor_Models_ProfessionRealmProxyInterface) newObject;
        Table table = realm.getTable(com.cashFlowAuditor.Models.Profession.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.DescriptionIndex, realmObjectSource.realmGet$Description());
        builder.addInteger(columnInfo.SalaryIndex, realmObjectSource.realmGet$Salary());
        builder.addInteger(columnInfo.TaxesIndex, realmObjectSource.realmGet$Taxes());
        builder.addInteger(columnInfo.HomeMortgagePaymentIndex, realmObjectSource.realmGet$HomeMortgagePayment());
        builder.addInteger(columnInfo.SchoolLoanPaymentIndex, realmObjectSource.realmGet$SchoolLoanPayment());
        builder.addInteger(columnInfo.CarLoanPaymentIndex, realmObjectSource.realmGet$CarLoanPayment());
        builder.addInteger(columnInfo.CreditCardPaymentIndex, realmObjectSource.realmGet$CreditCardPayment());
        builder.addInteger(columnInfo.RetailPaymentIndex, realmObjectSource.realmGet$RetailPayment());
        builder.addInteger(columnInfo.HomeMortgageIndex, realmObjectSource.realmGet$HomeMortgage());
        builder.addBoolean(columnInfo.HomeMortgagePaidIndex, realmObjectSource.realmGet$HomeMortgagePaid());
        builder.addInteger(columnInfo.SchoolLoanIndex, realmObjectSource.realmGet$SchoolLoan());
        builder.addBoolean(columnInfo.SchoolLoanPaidIndex, realmObjectSource.realmGet$SchoolLoanPaid());
        builder.addInteger(columnInfo.CarLoanIndex, realmObjectSource.realmGet$CarLoan());
        builder.addBoolean(columnInfo.CarLoanPaidIndex, realmObjectSource.realmGet$CarLoanPaid());
        builder.addInteger(columnInfo.CreditCardIndex, realmObjectSource.realmGet$CreditCard());
        builder.addBoolean(columnInfo.CreditCardPaidIndex, realmObjectSource.realmGet$CreditCardPaid());
        builder.addInteger(columnInfo.RetailDebtIndex, realmObjectSource.realmGet$RetailDebt());
        builder.addBoolean(columnInfo.RetailDebtPaidIndex, realmObjectSource.realmGet$RetailDebtPaid());
        builder.addInteger(columnInfo.PerChildExpenseIndex, realmObjectSource.realmGet$PerChildExpense());
        builder.addInteger(columnInfo.ChildNumberIndex, realmObjectSource.realmGet$ChildNumber());
        builder.addInteger(columnInfo.OtherExpensesIndex, realmObjectSource.realmGet$OtherExpenses());
        builder.addInteger(columnInfo.SavingsIndex, realmObjectSource.realmGet$Savings());
        builder.addBoolean(columnInfo.SelectedIndex, realmObjectSource.realmGet$Selected());
        builder.addInteger(columnInfo.LoanIndex, realmObjectSource.realmGet$Loan());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Profession = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Description:");
        stringBuilder.append(realmGet$Description() != null ? realmGet$Description() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Salary:");
        stringBuilder.append(realmGet$Salary());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Taxes:");
        stringBuilder.append(realmGet$Taxes());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{HomeMortgagePayment:");
        stringBuilder.append(realmGet$HomeMortgagePayment());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{SchoolLoanPayment:");
        stringBuilder.append(realmGet$SchoolLoanPayment());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{CarLoanPayment:");
        stringBuilder.append(realmGet$CarLoanPayment());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{CreditCardPayment:");
        stringBuilder.append(realmGet$CreditCardPayment());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{RetailPayment:");
        stringBuilder.append(realmGet$RetailPayment());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{HomeMortgage:");
        stringBuilder.append(realmGet$HomeMortgage());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{HomeMortgagePaid:");
        stringBuilder.append(realmGet$HomeMortgagePaid());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{SchoolLoan:");
        stringBuilder.append(realmGet$SchoolLoan());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{SchoolLoanPaid:");
        stringBuilder.append(realmGet$SchoolLoanPaid());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{CarLoan:");
        stringBuilder.append(realmGet$CarLoan());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{CarLoanPaid:");
        stringBuilder.append(realmGet$CarLoanPaid());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{CreditCard:");
        stringBuilder.append(realmGet$CreditCard());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{CreditCardPaid:");
        stringBuilder.append(realmGet$CreditCardPaid());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{RetailDebt:");
        stringBuilder.append(realmGet$RetailDebt());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{RetailDebtPaid:");
        stringBuilder.append(realmGet$RetailDebtPaid());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{PerChildExpense:");
        stringBuilder.append(realmGet$PerChildExpense());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{ChildNumber:");
        stringBuilder.append(realmGet$ChildNumber());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{OtherExpenses:");
        stringBuilder.append(realmGet$OtherExpenses());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Savings:");
        stringBuilder.append(realmGet$Savings());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Selected:");
        stringBuilder.append(realmGet$Selected());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Loan:");
        stringBuilder.append(realmGet$Loan());
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
        com_cashFlowAuditor_Models_ProfessionRealmProxy aProfession = (com_cashFlowAuditor_Models_ProfessionRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aProfession.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aProfession.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aProfession.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
