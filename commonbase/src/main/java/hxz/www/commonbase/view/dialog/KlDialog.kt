package com.xingxiu.frame.view.dialog

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.View
import com.xingxiu.frame.util.expand.click
import com.xingxiu.frame.util.expand.getColor
import com.xingxiu.frame.util.expand.setText
import hxz.www.commonbase.R
import kotlinx.android.synthetic.main.layout_dialog.*


/**
 *            demo for java:
 *            KlDialog.builder(getContext())
 *            .setNegativeButton(R.string.know, dialog -> {
 *            dialog.dismiss();
 *            return  null;
 *            })
 *            .setPositiveButton("哈哈", dialog -> {
 *            dialog.dismiss();
 *            return  null;
 *            })2
 *            .setLeftColor(R.color.colorAccent)
 *            .setMessage("何事秋风悲画扇")
 *            .setDialogTitle("人生若只如初见")
 *            .show();
 *            });
 *             **/

class KlDialog(context: Context) : Dialog(context, R.style.Dialog_Transparent) {

    companion object {
        @JvmStatic
        fun builder(context: Context): KlDialog = KlDialog(context)
    }

    interface OnKlDialogDismissListener {
        fun onDismiss()
    }

    private var onKlDialogDismissListener: OnKlDialogDismissListener? = null
    private var autoDismiss = false

    init {
        setContentView(R.layout.layout_dialog)
        window.setGravity(Gravity.CENTER)
        setOnDismissListener {
            onKlDialogDismissListener?.onDismiss()
        }
    }

    fun setDismissListener(onKlDialogDismissListener: OnKlDialogDismissListener): KlDialog {
        this.onKlDialogDismissListener = onKlDialogDismissListener
        return this
    }


    fun autoDismiss(): KlDialog {
        this.autoDismiss = true
        return this
    }

    fun setDialogTitle(title: Any?): KlDialog {
        if (title != null) {
            tv_dialog_title.setText(title)
            tv_dialog_title.visibility = View.VISIBLE
        }
        return this
    }

    fun setMessage(message: Any?): KlDialog {
        if (message != null) {
            tv_dialog_desc.setText(message)
        }
        return this
    }

    fun setNegativeButton(text: Any): KlDialog {
        tv_dialog_l_button.setOnClickListener {
            if (autoDismiss)
                dismiss()
        }
        tv_dialog_l_button.setText(text)
        tv_dialog_l_button.visibility = View.VISIBLE
        view_dialog_dividing.visibility = if (tv_dialog_r_button.visibility == View.GONE) View.GONE else View.VISIBLE
        return this
    }

    fun setNegativeButton(text: Any, leftClick: (dialog: KlDialog) -> Unit): KlDialog {
        tv_dialog_l_button.setOnClickListener {
            leftClick(this)
            if (autoDismiss)
                dismiss()
        }
        tv_dialog_l_button.setText(text)
        tv_dialog_l_button.visibility = View.VISIBLE
        view_dialog_dividing.visibility = if (tv_dialog_r_button.visibility == View.GONE) View.GONE else View.VISIBLE
        return this
    }

    fun setPositiveButton(text: Any, rightClick: (dialog: KlDialog) -> Unit): KlDialog {
        tv_dialog_r_button.click {
                rightClick(this)
            if (autoDismiss)
                dismiss()
        }
        tv_dialog_r_button.setText(text)
        tv_dialog_r_button.visibility = View.VISIBLE
        view_dialog_dividing.visibility = if (tv_dialog_l_button.visibility == View.GONE) View.GONE else View.VISIBLE
        return this
    }

    fun setPositiveButton(text: Any): KlDialog {
        tv_dialog_r_button.click {
            if (autoDismiss)
                dismiss()
        }
        tv_dialog_r_button.setText(text)
        tv_dialog_r_button.visibility = View.VISIBLE
        view_dialog_dividing.visibility = if (tv_dialog_l_button.visibility == View.GONE) View.GONE else View.VISIBLE
        return this
    }

    fun setLeftColor(leftColor: Int): KlDialog {
        tv_dialog_l_button.setTextColor(leftColor.getColor())
        return this
    }

    fun setRightColor(rightColor: Int): KlDialog {
        tv_dialog_r_button.setTextColor(rightColor.getColor())
        return this
    }

    fun setCanceloutside(cancel: Boolean): KlDialog {
        this.setCanceledOnTouchOutside(cancel)
        return this
    }

}