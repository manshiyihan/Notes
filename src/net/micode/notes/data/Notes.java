/*
 * Copyright (c) 2010-2011, The MiCode Open Source Community (www.micode.net)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// 包声明，指定该类所属的包
package net.micode.notes.data;

// 导入 Android 中的 Uri 类，用于表示统一资源标识符
import android.net.Uri;

/**
 * Notes 类用于定义笔记应用的数据相关常量和接口，
 * 包含笔记和文件夹的类型、系统文件夹的 ID、Intent 额外数据的键名、
 * 数据查询的 Uri 以及笔记和数据的列名等信息。
 */
public class Notes {
    // 内容提供者的权限，用于标识应用的内容提供者
    public static final String AUTHORITY = "micode_notes";
    // 日志标签，用于在日志中标识该类的日志信息
    public static final String TAG = "Notes";
    // 笔记类型的常量，值为 0 表示这是一个笔记
    public static final int TYPE_NOTE = 0;
    // 文件夹类型的常量，值为 1 表示这是一个文件夹
    public static final int TYPE_FOLDER = 1;
    // 系统类型的常量，值为 2 表示这是系统相关的类型
    public static final int TYPE_SYSTEM = 2;

    /**
     * 以下常量是系统文件夹的标识符：
     * {@link Notes#ID_ROOT_FOLDER } 是默认文件夹
     * {@link Notes#ID_TEMPARAY_FOLDER } 用于存放不属于任何文件夹的笔记
     * {@link Notes#ID_CALL_RECORD_FOLDER} 用于存储通话记录
     */
    // 根文件夹的 ID，值为 0
    public static final int ID_ROOT_FOLDER = 0;
    // 临时文件夹的 ID，值为 -1
    public static final int ID_TEMPARAY_FOLDER = -1;
    // 通话记录文件夹的 ID，值为 -2
    public static final int ID_CALL_RECORD_FOLDER = -2;
    // 回收站文件夹的 ID，值为 -3
    public static final int ID_TRASH_FOLER = -3;

    // Intent 额外数据的键名，用于传递提醒日期
    public static final String INTENT_EXTRA_ALERT_DATE = "net.micode.notes.alert_date";
    // Intent 额外数据的键名，用于传递背景颜色的 ID
    public static final String INTENT_EXTRA_BACKGROUND_ID = "net.micode.notes.background_color_id";
    // Intent 额外数据的键名，用于传递小部件的 ID
    public static final String INTENT_EXTRA_WIDGET_ID = "net.micode.notes.widget_id";
    // Intent 额外数据的键名，用于传递小部件的类型
    public static final String INTENT_EXTRA_WIDGET_TYPE = "net.micode.notes.widget_type";
    // Intent 额外数据的键名，用于传递文件夹的 ID
    public static final String INTENT_EXTRA_FOLDER_ID = "net.micode.notes.folder_id";
    // Intent 额外数据的键名，用于传递通话日期
    public static final String INTENT_EXTRA_CALL_DATE = "net.micode.notes.call_date";

    // 无效小部件类型的常量，值为 -1
    public static final int TYPE_WIDGET_INVALIDE = -1;
    // 2x 大小小部件类型的常量，值为 0
    public static final int TYPE_WIDGET_2X = 0;
    // 4x 大小小部件类型的常量，值为 1
    public static final int TYPE_WIDGET_4X = 1;

    /**
     * DataConstants 类用于定义数据相关的常量，
     * 包含笔记和通话记录的 MIME 类型。
     */
    public static class DataConstants {
        // 笔记的 MIME 类型，使用 TextNote 类的 CONTENT_ITEM_TYPE
        public static final String NOTE = TextNote.CONTENT_ITEM_TYPE;
        // 通话记录的 MIME 类型，使用 CallNote 类的 CONTENT_ITEM_TYPE
        public static final String CALL_NOTE = CallNote.CONTENT_ITEM_TYPE;
    }

    /**
     * 用于查询所有笔记和文件夹的 Uri。
     * 通过该 Uri 可以访问内容提供者获取笔记和文件夹的数据。
     */
    public static final Uri CONTENT_NOTE_URI = Uri.parse("content://" + AUTHORITY + "/note");

    /**
     * 用于查询数据的 Uri。
     * 通过该 Uri 可以访问内容提供者获取笔记相关的数据。
     */
    public static final Uri CONTENT_DATA_URI = Uri.parse("content://" + AUTHORITY + "/data");

    /**
     * NoteColumns 接口定义了笔记表的列名常量，
     * 包含笔记和文件夹的各种属性列名。
     */
    public interface NoteColumns {
        /**
         * 行的唯一 ID
         * <P> 类型: INTEGER (long) </P>
         */
        public static final String ID = "_id";

        /**
         * 笔记或文件夹的父 ID
         * <P> 类型: INTEGER (long) </P>
         */
        public static final String PARENT_ID = "parent_id";

        /**
         * 笔记或文件夹的创建日期
         * <P> 类型: INTEGER (long) </P>
         */
        public static final String CREATED_DATE = "created_date";

        /**
         * 最新修改日期
         * <P> 类型: INTEGER (long) </P>
         */
        public static final String MODIFIED_DATE = "modified_date";

        /**
         * 提醒日期
         * <P> 类型: INTEGER (long) </P>
         */
        public static final String ALERTED_DATE = "alert_date";

        /**
         * 文件夹的名称或笔记的文本内容
         * <P> 类型: TEXT </P>
         */
        public static final String SNIPPET = "snippet";

        /**
         * 笔记的小部件 ID
         * <P> 类型: INTEGER (long) </P>
         */
        public static final String WIDGET_ID = "widget_id";

        /**
         * 笔记的小部件类型
         * <P> 类型: INTEGER (long) </P>
         */
        public static final String WIDGET_TYPE = "widget_type";

        /**
         * 笔记的背景颜色 ID
         * <P> 类型: INTEGER (long) </P>
         */
        public static final String BG_COLOR_ID = "bg_color_id";

        /**
         * 对于文本笔记，没有附件；对于多媒体笔记，至少有一个附件
         * <P> 类型: INTEGER </P>
         */
        public static final String HAS_ATTACHMENT = "has_attachment";

        /**
         * 文件夹中的笔记数量
         * <P> 类型: INTEGER (long) </P>
         */
        public static final String NOTES_COUNT = "notes_count";

        /**
         * 文件类型：文件夹或笔记
         * <P> 类型: INTEGER </P>
         */
        public static final String TYPE = "type";

        /**
         * 最后同步的 ID
         * <P> 类型: INTEGER (long) </P>
         */
        public static final String SYNC_ID = "sync_id";

        /**
         * 标识是否本地修改的标志
         * <P> 类型: INTEGER </P>
         */
        public static final String LOCAL_MODIFIED = "local_modified";

        /**
         * 移动到临时文件夹之前的原始父 ID
         * <P> 类型 : INTEGER </P>
         */
        public static final String ORIGIN_PARENT_ID = "origin_parent_id";

        /**
         * Google 任务的 ID
         * <P> 类型 : TEXT </P>
         */
        public static final String GTASK_ID = "gtask_id";

        /**
         * 版本号
         * <P> 类型 : INTEGER (long) </P>
         */
        public static final String VERSION = "version";
    }

    /**
     * DataColumns 接口定义了数据表的列名常量，
     * 包含数据的各种属性列名。
     */
    public interface DataColumns {
        /**
         * 行的唯一 ID
         * <P> 类型: INTEGER (long) </P>
         */
        public static final String ID = "_id";

        /**
         * 该行所代表项目的 MIME 类型
         * <P> 类型: Text </P>
         */
        public static final String MIME_TYPE = "mime_type";

        /**
         * 该数据所属笔记的引用 ID
         * <P> 类型: INTEGER (long) </P>
         */
        public static final String NOTE_ID = "note_id";

        /**
         * 笔记或文件夹的创建日期
         * <P> 类型: INTEGER (long) </P>
         */
        public static final String CREATED_DATE = "created_date";

        /**
         * 最新修改日期
         * <P> 类型: INTEGER (long) </P>
         */
        public static final String MODIFIED_DATE = "modified_date";

        /**
         * 数据的内容
         * <P> 类型: TEXT </P>
         */
        public static final String CONTENT = "content";

        /**
         * 通用数据列，含义取决于 {@link #MIMETYPE}，用于整数类型数据
         * <P> 类型: INTEGER </P>
         */
        public static final String DATA1 = "data1";

        /**
         * 通用数据列，含义取决于 {@link #MIMETYPE}，用于整数类型数据
         * <P> 类型: INTEGER </P>
         */
        public static final String DATA2 = "data2";

        /**
         * 通用数据列，含义取决于 {@link #MIMETYPE}，用于文本类型数据
         * <P> 类型: TEXT </P>
         */
        public static final String DATA3 = "data3";

        /**
         * 通用数据列，含义取决于 {@link #MIMETYPE}，用于文本类型数据
         * <P> 类型: TEXT </P>
         */
        public static final String DATA4 = "data4";

        /**
         * 通用数据列，含义取决于 {@link #MIMETYPE}，用于文本类型数据
         * <P> 类型: TEXT </P>
         */
        public static final String DATA5 = "data5";
    }

    /**
     * TextNote 类是一个静态常量类，实现了 DataColumns 接口，
     * 定义了文本笔记相关的常量，包括模式、内容类型和 Uri。
     */
    public static final class TextNote implements DataColumns {
        /**
         * 指示文本是否处于复选列表模式的模式
         * <P> 类型: Integer 1: 复选列表模式 0: 正常模式 </P>
         */
        public static final String MODE = DATA1;

        // 复选列表模式的常量值
        public static final int MODE_CHECK_LIST = 1;

        // 文本笔记集合的内容类型
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/text_note";

        // 单个文本笔记的内容类型
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/text_note";

        // 用于查询文本笔记的 Uri
        public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/text_note");
    }

    /**
     * CallNote 类是一个静态常量类，实现了 DataColumns 接口，
     * 定义了通话记录笔记相关的常量，包括通话日期、电话号码、内容类型和 Uri。
     */
    public static final class CallNote implements DataColumns {
        /**
         * 该记录的通话日期
         * <P> 类型: INTEGER (long) </P>
         */
        public static final String CALL_DATE = DATA1;

        /**
         * 该记录的电话号码
         * <P> 类型: TEXT </P>
         */
        public static final String PHONE_NUMBER = DATA3;

        // 通话记录笔记集合的内容类型
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/call_note";

        // 单个通话记录笔记的内容类型
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/call_note";

        // 用于查询通话记录笔记的 Uri
        public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/call_note");
    }
}
