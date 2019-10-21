package com.xingxiu.frame.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import hxz.www.commonbase.R
import org.jetbrains.annotations.NotNull


class ItemClickSupport private constructor(private val mRecyclerView: RecyclerView) {
    private val childListenerMap = hashMapOf<Int, OnChildClickListener>()

    private val mAttachListener = object : RecyclerView.OnChildAttachStateChangeListener {
        override fun onChildViewAttachedToWindow(view: View) {

            //子 View 点击
            if (childListenerMap.isNotEmpty()) {
                for (key in childListenerMap.keys) {
                    view.findViewById<View>(key)?.setOnClickListener { v ->
                        val holder = mRecyclerView.findContainingViewHolder(v)
                        if (holder != null && holder.adapterPosition != -1) {
                            childListenerMap[key]!!.onChildClicked(mRecyclerView, holder.adapterPosition, v)
                        }
                    }
                }

            }
        }

        override fun onChildViewDetachedFromWindow(view: View) {
        }
    }

    init {
        mRecyclerView.setTag(R.id.item_click_support, this)
        mRecyclerView.addOnChildAttachStateChangeListener(mAttachListener)
    }

    /**
     * 子view添加点击事件
     */
    fun addOnChildClickListener(resId: Int, @NotNull listener: OnChildClickListener): ItemClickSupport {
        childListenerMap[resId] = listener
        return this
    }

    private fun detach(view: RecyclerView) {
        view.removeOnChildAttachStateChangeListener(mAttachListener)
        view.setTag(R.id.item_click_support, null)
    }

    // 子 View点击接口
    interface OnChildClickListener {
        fun onChildClicked(recyclerView: RecyclerView, position: Int, v: View)
    }


    companion object {

        @JvmStatic
        fun addTo(view: RecyclerView): ItemClickSupport {
            var support: ItemClickSupport? = view.getTag(R.id.item_click_support) as ItemClickSupport?
            if (support == null) {
                support = ItemClickSupport(view)
            }
            return support
        }

        @JvmStatic
        fun removeFrom(view: RecyclerView): ItemClickSupport? {
            val support = view.getTag(R.id.item_click_support) as ItemClickSupport
            support.detach(view)
            return support
        }
    }
}
