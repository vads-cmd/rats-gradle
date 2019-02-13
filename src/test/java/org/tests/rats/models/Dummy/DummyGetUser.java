package org.tests.rats.models.Dummy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class DummyGetUser {

    @SerializedName("data")
    @Expose
    private DummyUserData data;

    public DummyUserData getData() {
        return data;
    }

    public void setData(DummyUserData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("data", data).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(data).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DummyGetUser) == false) {
            return false;
        }
        DummyGetUser rhs = ((DummyGetUser) other);
        return new EqualsBuilder().append(data, rhs.data).isEquals();
    }

}