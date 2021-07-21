package com.example.bookdata.message;

import android.util.JsonWriter;
import android.util.Log;

import java.io.Closeable;
import java.io.IOException;

public class ChatMessageWriter implements Closeable {
    private final static String TAG = ChatMessageWriter.class.getSimpleName();
    private final JsonWriter writer;

    public ChatMessageWriter(JsonWriter writer) {
        this.writer = writer;
    }

    @Override
    public void close() throws IOException {
        Log.d(TAG, "close");
        writer.close();
    }

    public void flush() throws IOException {
        Log.d(TAG, "flush");
        writer.flush();
    }

    public void beginArray() throws IOException {
        Log.d(TAG, "beginArray");
        writer.beginArray();
    }

    public void endArray() throws IOException {
        Log.d(TAG, "endArray");
        writer.endArray();
    }

    public void write(ChatMessage message) throws IOException {
        Log.d(TAG, "write");
        writer.beginObject();
        writer.name(ChatMessage.FIELD_SEQ).value(message.seq);
        writer.name(ChatMessage.FIELD_TIME).value(message.time);
        writer.name(ChatMessage.FIELD_NOTE);
        if (message.note == null) {
            writer.nullValue();
        } else {
            writer.value(message.note);
        }
        writer.name(ChatMessage.FIELD_TITLE);
        if (message.title == null) {
            writer.nullValue();
        } else {
            writer.value(message.title);
        }
        writer.name(ChatMessage.FIELD_ISBN);
        if (message.isbn == null) {
            writer.nullValue();
        } else {
            writer.value(message.isbn);
        }
        writer.name(ChatMessage.FIELD_PRICE);
        if (message.price == null) {
            writer.nullValue();
        } else {
            writer.value(message.price);
        }
        writer.name(ChatMessage.FIELD_SENDER);
        if (message.sender == null) {
            writer.nullValue();
        } else {
            writer.value(message.sender);
        }
        writer.endObject();
    }
}
