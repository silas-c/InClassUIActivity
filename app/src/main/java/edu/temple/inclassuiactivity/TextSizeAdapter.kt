package edu.temple.inclassuiactivity

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class TextSizeAdapter(private val context: Context, private val text: Array<Int>) : BaseAdapter() {
    override fun getCount(): Int {
        return text.size
    }

    override fun getItem(position: Int): Any {
        return text[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val textView = (convertView as? TextView) ?: TextView(context)
        textView.text = text[position].toString()
        textView.textSize = text[position].toFloat()
        return textView
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val textView = (getView(position, convertView, parent) as TextView)
        textView.textSize = text[position].toFloat()
        return textView
    }
}
