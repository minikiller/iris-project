package com.liming.platform.couchdb.model;

import java.util.*;

import org.lightcouch.Attachment;

/**
 * Created by dell on 14-3-20.
 */
public class Foo {
    private String _id;
private String _rev;

private String title;
private int position;
private List<String> tags;
private int[] complexDate;
private Set<Bar> bars;
private Date date;
private Map<String, Attachment> _attachments;
private List<RevInfo> _revs_info;

        public Foo() {
            super();
        }

        public Foo(String _id) {
            this._id = _id;
        }

        public Foo(String _id, String title) {
            this._id = _id;
            this.title = title;
        }

        public String get_id() {
            return _id;
        }

        public String get_rev() {
            return _rev;
        }

        public String getTitle() {
            return title;
        }

        public int getPosition() {
            return position;
        }

        public List<String> getTags() {
            return tags;
        }

        public int[] getComplexDate() {
            return complexDate;
        }

        public Set<Bar> getBars() {
            return bars;
        }

        public Date getDate() {
            return date;
        }

        public Map<String, Attachment> get_attachments() {
            return _attachments;
        }

        public List<RevInfo> get_revs_info() {
            return _revs_info;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public void set_rev(String _rev) {
            this._rev = _rev;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public void setComplexDate(int[] complexDate) {
            this.complexDate = complexDate;
        }

        public void setBars(Set<Bar> bars) {
            this.bars = bars;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public void set_attachments(Map<String, Attachment> _attachments) {
            this._attachments = _attachments;
        }

        public void set_revs_info(List<RevInfo> _revs_info) {
            this._revs_info = _revs_info;
        }

        @Override
        public String toString() {
            return "Foo [_id=" + _id + ", _rev=" + _rev + ", title=" + title + ", position="
                    + position + ", tags=" + tags + ", complexDate="
                    + Arrays.toString(complexDate) + ", bars=" + bars + ", _revs_info="
                    + _revs_info + "]";
        }

public static class RevInfo {
    private String rev;
    private String status;

    public String getRev() {
        return rev;
    }

    public void setRev(String rev) {
        this.rev = rev;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RevInfo [rev=" + rev + ", status=" + status + "]";
    }
} // end RevInfo

} // end Foo