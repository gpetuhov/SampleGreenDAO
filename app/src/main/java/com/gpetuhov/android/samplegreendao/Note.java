package com.gpetuhov.android.samplegreendao;

// Entity classes must be in JAVA.
// As to https://github.com/greenrobot/greenDAO/issues/395 issue comment:
// "There likely will be no support for entities written in Kotlin.
// Check out ObjectBox, our new fast, easy to use database"

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Note {

    @Id(autoincrement = true)
    private Long id;

    private String text;

    @Transient
    private int someNotPersistedValue; // not persisted

    @Generated(hash = 1816070532)
    public Note(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    @Generated(hash = 1272611929)
    public Note() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
