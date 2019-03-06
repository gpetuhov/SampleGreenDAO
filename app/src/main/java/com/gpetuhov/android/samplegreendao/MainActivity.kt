package com.gpetuhov.android.samplegreendao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var noteDao: NoteDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get DAO for notes
        noteDao = (application as SampleGreenDaoApp).daoSession.noteDao

        saveNoteButton.setOnClickListener {
            val note = Note()
            note.text = editText.text.toString()
            noteDao.insert(note)
        }
    }
}
