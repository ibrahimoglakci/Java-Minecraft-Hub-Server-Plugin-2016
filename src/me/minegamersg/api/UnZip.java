package me.minegamersg.api;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZip
{
  @SuppressWarnings("unused")
private static final int BUFFER_SIZE = 4096;
  
  public void unzip(String paramString1, String paramString2) throws IOException
  {
    File localFile1 = new File(paramString2);
    if (!localFile1.exists()) {
      localFile1.mkdir();
    }
    ZipInputStream localZipInputStream = new ZipInputStream(new FileInputStream(paramString1));
    ZipEntry localZipEntry = localZipInputStream.getNextEntry();
    while (localZipEntry != null)
    {
      String str = paramString2 + File.separator + localZipEntry.getName();
      if (!localZipEntry.isDirectory())
      {
        extractFile(localZipInputStream, str);
      }
      else
      {
        File localFile2 = new File(str);
        localFile2.mkdir();
      }
      localZipInputStream.closeEntry();
      localZipEntry = localZipInputStream.getNextEntry();
    }
    localZipInputStream.close();
  }
  
  private void extractFile(ZipInputStream paramZipInputStream, String paramString) throws IOException
  {
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(paramString));
    byte[] arrayOfByte = new byte[4096];
    int i = 0;
    while ((i = paramZipInputStream.read(arrayOfByte)) != -1) {
      localBufferedOutputStream.write(arrayOfByte, 0, i);
    }
    localBufferedOutputStream.close();
  }
}
