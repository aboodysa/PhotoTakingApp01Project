package com.shaheen.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by shaheen on 11/4/13.
 */
public class Utils {
    @Deprecated
    public static void bindDTOAndPOJO(Object source, Object target) throws InvocationTargetException {
        bindDTOAndPOJO(source, target, 1);
    }
    public static void saveJPGFromBitMap(Bitmap imageBitMap, Uri fileUri, Context context) throws IOException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        imageBitMap.compress(Bitmap.CompressFormat.JPEG, 40, bytes);
        File f = new File(fileUri.getPath());
        f.createNewFile();
        FileOutputStream fo = new FileOutputStream(f);
        fo.write(bytes.toByteArray());
        fo.close();
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.parse("file://" + Environment.getExternalStorageDirectory())));
    }
    public static Uri generateTimeStampPhotoFileUri()
    {
        Uri photoFileUri = null;
        File outputDir = getPhotoDirectory();
        if(outputDir != null)
        {
            String timeStamp = new SimpleDateFormat("yyyyMMDD_HHmmss").format(new Date());
            String photoFileName = "IMG_"+timeStamp+".jpg";
            File photoFile = new File(outputDir,photoFileName);
            photoFileUri = Uri.fromFile(photoFile);
        }
        return photoFileUri;
    }
    //create directory for application
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static File getPhotoDirectory()
    {
        File outDirectory = null;
        String state = Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)) {
            File pictureDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            outDirectory = new File(pictureDir, "TasksManagement");
            if(!outDirectory.exists()) {
                if(!outDirectory.mkdirs()) {
                    //Toast.makeText(this, "Failed to create FolderResult", Toast.LENGTH_LONG).show();
                    outDirectory =null;
                }
            }
        }
        return  outDirectory;
    }
    /**
     * index = 0, copies happens at first level without indexing
     *
     * @param source
     * 		the source Object to copy data from
     * @param target
     * 		the source Object to copy data to
     * @param indexDepth
     * 		indexing level of coping data
     *
     */
    public static void bindDTOAndPOJO(Object source, Object target, int indexDepth) throws InvocationTargetException {
        if( source == null || target == null )
            return;
        Class sourceClass = source.getClass();
        Class targetClass = target.getClass();

        Field sourceFieldList[] = sourceClass.getDeclaredFields();
        Method targetMethodList[] = targetClass.getDeclaredMethods();
        for (Field field : sourceFieldList) {
            try {
                String fieldName = field.getName();

                String srouceGetterName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                Method sourceGetterMethod = sourceClass.getMethod(srouceGetterName);
                Field targetField = targetClass.getDeclaredField(fieldName);
                Method targetSetterMethod = targetClass.getMethod("set" + srouceGetterName.substring(3), new Class[] { targetField.getType() });
                Object value = sourceGetterMethod.invoke(source);
//				if(value == null)
//					continue;
                if(!invokeSetterMethod(target, field.getType(), targetSetterMethod, value))
                {
                    if(0 == indexDepth)
                        continue;

                    Object fieldInstance = targetField.getType().newInstance();
                    targetSetterMethod.invoke(target, fieldInstance);

                    Method targetGetterMethod = targetClass.getMethod(srouceGetterName);

                    bindDTOAndPOJO(sourceGetterMethod.invoke(source), targetGetterMethod.invoke(target), (indexDepth-1) );
                }


            } catch (SecurityException e) {
                // TODO Auto-generated catch block
                System.out.println("Security Exception");
            } catch (NoSuchMethodException e) {
                // TODO Auto-generated catch block
                System.out.println("No Such Method Exception");
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                System.out.println("Illegal Argument Exception");
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                System.out.println("Illegal Access Exception");
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                System.out.println("Invocation Target Exception");
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                System.out.println("Parse Exception");
            } catch (NoSuchFieldException e) {
                // TODO Auto-generated catch block
                System.out.println("No Such Field Exception");
            } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                System.out.println("Instantiation Exception");
            }
        }
    }

    private static boolean invokeSetterMethod(Object invokerInstance,
                                              Class<?> fieldType, Method targetSetterMethod, Object sourceValue) throws SecurityException,
            NoSuchMethodException, IllegalArgumentException,
            IllegalAccessException, InvocationTargetException, ParseException {
        try {
            if (sourceValue == null)
                return true;

            String value = sourceValue.toString();

            boolean result = true;
            String typeName = fieldType.getSimpleName();

            if (typeName.equals("String"))
                targetSetterMethod.invoke(invokerInstance, value);
            else if (typeName.equals("Integer") || typeName.equals("int")) {
                if (value != null && value.length() > 0)
                    targetSetterMethod.invoke(invokerInstance, new Integer(
                            Integer.parseInt(value)));
                else
                    targetSetterMethod.invoke(invokerInstance, (Object) null);
            } else if (typeName.equals("Long") || typeName.equals("long")) {
                if (value != null && value.length() > 0)
                    targetSetterMethod.invoke(invokerInstance,
                            new Long(Long.parseLong(value)));
                else
                    targetSetterMethod.invoke(invokerInstance, (Object) null);
            } else if (typeName.equals("Float") || typeName.equals("float")) {
                if (value != null && value.length() > 0)
                    targetSetterMethod.invoke(invokerInstance,
                            new Float(Float.parseFloat(value)));
                else
                    targetSetterMethod.invoke(invokerInstance, (Object) null);
            } else if (typeName.equals("Boolean") || typeName.equals("boolean")) {
                if (value != null && value.length() > 0)
                    targetSetterMethod.invoke(invokerInstance, new Boolean(
                            "true".equals(value)));
                else
                    targetSetterMethod.invoke(invokerInstance, (Object) null);

            } else if (typeName.equals("Date"))
                targetSetterMethod.invoke(invokerInstance, (Date) sourceValue);
            else {// Nesting Objects
                result = false;
            }

            return result;
        } catch (Exception e) {
            // object is lazy with null value
            return true;
        }
    }

    public  static Date getDateFromNetDate(String input)
    {
        String JSONDateToMilliseconds = "\\/(Date\\((.*?)(\\+.*)?\\))\\/";
        Pattern pattern = Pattern.compile(JSONDateToMilliseconds);
        Matcher matcher = pattern.matcher(input);
        String result = matcher.replaceAll("$2");
        return new Date(new Long(result));
    }
    public static String setDateToNetDate(Date date, TimeZone timeZone)
    {
        Long milliSeconds = date.getTime();
        //Long offsetZone = timeZone.
        return "\\/Date("+milliSeconds+"-"+timeZone.getRawOffset()+")\\/";
    }


    public static Date readMsDate(String msDate)  {

        Date result = null;
        String str =  msDate .replaceAll("[^0-9]", "");
        if (!TextUtils.isEmpty(str)) {
            try {
                result = new Date(Long.parseLong(str));
            } catch (NumberFormatException e) {
            }
        }
        return result;
    }

    public static Uri.Builder GetUrl(String url, Map<String, Object> map)
    {
        Uri.Builder uriBuilder = Uri.parse(url).buildUpon();
        for (Map.Entry entry : map.entrySet()) {
            uriBuilder.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
        }
        return uriBuilder;
    }
}
