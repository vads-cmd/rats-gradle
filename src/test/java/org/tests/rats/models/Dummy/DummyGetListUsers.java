package org.tests.rats.models.Dummy;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class DummyGetListUsers {
    @SerializedName("page")
    @Expose
    private int page;
    @SerializedName("per_page")
    @Expose
    private int perPage;
    @SerializedName("total")
    @Expose
    private int total;
    @SerializedName("total_pages")
    @Expose
    private int totalPages;
    @SerializedName("data")
    @Expose
    private List<DummyUserData> data = null;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<DummyUserData> getData() {
        return data;
    }

    public void setData(List<DummyUserData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("page", page).append("perPage", perPage).append("total", total).append("totalPages", totalPages).append("data", data).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(total).append(page).append(data).append(perPage).append(totalPages).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DummyGetListUsers) == false) {
            return false;
        }
        DummyGetListUsers rhs = ((DummyGetListUsers) other);
        return new EqualsBuilder().append(total, rhs.total).append(page, rhs.page).append(data, rhs.data).append(perPage, rhs.perPage).append(totalPages, rhs.totalPages).isEquals();
    }


}
