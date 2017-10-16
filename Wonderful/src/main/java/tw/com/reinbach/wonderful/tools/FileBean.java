package tw.com.reinbach.wonderful.tools;

public class FileBean {
	
	private String fileName;
	private String fileExtension;
	private long fileLengtn;
	private byte[] fileBinary;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileExtension() {
		return fileExtension;
	}
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}
	public long getFileLengtn() {
		return fileLengtn;
	}
	public void setFileLengtn(long fileLengtn) {
		this.fileLengtn = fileLengtn;
	}
	public byte[] getFileBinary() {
		return fileBinary;
	}
	public void setFileBinary(byte[] fileBinary) {
		this.fileBinary = fileBinary;
	}

}
