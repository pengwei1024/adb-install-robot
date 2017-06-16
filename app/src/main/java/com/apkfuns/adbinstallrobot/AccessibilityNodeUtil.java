package com.apkfuns.adbinstallrobot;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;

import java.util.List;

/**
 * Created by pengwei on 2017/1/29.
 */

public class AccessibilityNodeUtil {

    /**
     * 设置文本
     * @param node
     * @param text
     */
    public static void setText(AccessibilityNodeInfo node, String text) {
        if (node != null & node.getClassName().equals("android.widget.EditText")) {
            Bundle arguments = new Bundle();
            arguments.putCharSequence(AccessibilityNodeInfo
                    .ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, text);
            node.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, arguments);
        }
    }

    /**
     * 点击事件
     * @param node
     */
    public static void click(AccessibilityNodeInfo node) {
        node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
    }

    /**
     * 根据id查找结点，存在返回不存在返回null
     *
     * @param nodeInfo
     * @param viewId
     * @return
     */
    public static AccessibilityNodeInfo findNodeById(AccessibilityNodeInfo nodeInfo, String viewId) {
        if (nodeInfo == null || viewId == null) {
            return null;
        }
        List<AccessibilityNodeInfo> list = nodeInfo.findAccessibilityNodeInfosByViewId(viewId);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

}
