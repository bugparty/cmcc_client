/*
 * This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.ifancc.wifimgr;

import com.ifancc.wifimgr.Bean.Wifi;
import com.ifancc.wifimgr.Bean.WlanInterfaceInfoList;

import java.lang.reflect.Field;

/**
 * @author bowman
 * Created by bowman on 14-1-2.
 */
public class Manager {
    static {
        System.setProperty("java.library.path",
                System.getProperty("java.library.path")
                + ";D:\\coursera_scale\\cmcc\\Debug");
        Field fieldSysPath = null;
//        try {
//            fieldSysPath = ClassLoader.class.getDeclaredField("sys_paths");
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
//        fieldSysPath.setAccessible(true);
//        try{
//        fieldSysPath.set(null, null);
//        }
//        catch( IllegalAccessException e){
//            e.printStackTrace();
//        }
        System.loadLibrary("Debug/wifimgr");
    }
    public native WlanInterfaceInfoList  WlanEnumInterfaces();



}
