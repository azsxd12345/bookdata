package com.example.bookdata.message;

import android.os.Parcel;
import android.os.Parcelable;

public class ChatMessage implements Parcelable {
    final static String FIELD_SEQ = "seq";
    final static String FIELD_TIME = "time";
    final static String FIELD_ISBN = "isbn";
    final static String FIELD_TITLE = "title";
    final static String FIELD_PRICE = "price";
    final static String FIELD_NOTE = "note";
    final static String FIELD_SENDER = "sender";

    public final int seq;
    public final long time;
    public final String isbn;
    public final String title;
    public final String price;
    public final String note;
    public final String sender;



    public ChatMessage(int seq, long time, String isbn,String title,String price,String note, String sender) {
        this.seq = seq;
        this.time = time;
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.note = note;
        this.sender = sender;
    }


    private ChatMessage(Parcel in) {
        seq = in.readInt();
        time = in.readLong();
        isbn = in.readString();
        title = in.readString();
        price = in.readString();
        note = in.readString();
        sender = in.readString();
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public String toString() {
        return note;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(seq);
        dest.writeLong(time);
        dest.writeString(isbn);
        dest.writeString(title);
        dest.writeString(price);
        dest.writeString(note);
        dest.writeString(sender);
    }

    public static final Creator<ChatMessage> CREATOR = new Creator<ChatMessage>() {
        @Override
        public ChatMessage createFromParcel(Parcel src) {
            return new ChatMessage(src);
        }

        @Override
        public ChatMessage[] newArray(int size) {
            return new ChatMessage[size];
        }
    };
}
