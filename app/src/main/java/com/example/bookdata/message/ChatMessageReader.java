package com.example.bookdata.message;

import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;

import java.io.Closeable;
import java.io.IOException;

public class ChatMessageReader implements Closeable {
    private final static String TAG = ChatMessageReader.class.getSimpleName();
    private final JsonReader reader;

    public ChatMessageReader(JsonReader reader) {
        this.reader = reader;
    }

    @Override
    public void close() throws IOException {
        Log.d(TAG, "close");
        reader.close();
    }

    public boolean hasNext() throws IOException {
        Log.d(TAG, "hasNext");
        return reader.hasNext();
    }

    public void beginArray() throws IOException {
        Log.d(TAG, "beginArray");
        reader.beginArray();
    }

    public void endArray() throws IOException {
        Log.d(TAG, "endArray");
        reader.endArray();
    }

    public ChatMessage read() throws IOException {
        Log.d(TAG, "read");
        int seq = -1;
        long time = -1;
        String price = null;
        String title = null;
        String isbn = null;
        String note = null;
        String sender = null;
        int sound = 0;
        reader.beginObject();
        while (reader.hasNext()) {
            switch (reader.nextName()) {
                case ChatMessage.FIELD_SEQ:
                    seq = reader.nextInt();
                    break;
                case ChatMessage.FIELD_TIME:
                    time = reader.nextLong();
                    break;
                case ChatMessage.FIELD_ISBN:
                    if (reader.peek() == JsonToken.NULL) {
                        reader.skipValue();
                        isbn = null;
                    } else {
                        isbn = reader.nextString();
                    }
                    break;
                case ChatMessage.FIELD_TITLE:
                    if (reader.peek() == JsonToken.NULL) {
                        reader.skipValue();
                        title = null;
                    } else {
                        title = reader.nextString();
                    }
                    break;
                case ChatMessage.FIELD_PRICE:
                    if (reader.peek() == JsonToken.NULL) {
                        reader.skipValue();
                        price = null;
                    } else {
                        price = reader.nextString();
                    }
                    break;
                case ChatMessage.FIELD_NOTE:
                    if (reader.peek() == JsonToken.NULL) {
                        reader.skipValue();
                        note = null;
                    } else {
                        note = reader.nextString();
                    }
                    break;
                case ChatMessage.FIELD_SENDER:
                    if (reader.peek() == JsonToken.NULL) {
                        reader.skipValue();
                        sender = null;
                    } else {
                        sender = reader.nextString();
                    }
                    break;
            }
        }
            reader.endObject();
            return new ChatMessage(seq, time, isbn, title, price, note, sender);
    }
}
