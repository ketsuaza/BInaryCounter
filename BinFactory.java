package logicExperience;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BinFactory {
	private int digit;
	private String fileName;
	BinFactory(int digit,String fileName){
		this.digit=digit;
		this.fileName=fileName;
	}
	public String generateBin(int num){
		String returnString = Integer.toBinaryString(num);
		List<String> buff;
		Iterator<String> itr;
		while(returnString.length()<digit){
			returnString="0"+returnString;
		}
		buff=Arrays.asList(returnString.split(""));
		itr=buff.iterator();
		returnString="";
		for(String tmp="";itr.hasNext();){
			tmp=itr.next();
			returnString=returnString+tmp+",";
		}
		returnString=returnString.substring(0, returnString.length()-1);
		return  returnString;
	}
	public ArrayList<String> generateBinList(){
		ArrayList<String> returnList=new ArrayList<String>();
		for(int i=0;i<Math.pow(2, digit);i++){
			returnList.add(this.generateBin(i));
		}
		return returnList;
	}
	public void generateCSV(){
		try {
			BufferedWriter writer=new BufferedWriter(new FileWriter(fileName));
			Iterator itr=this.generateBinList().iterator();
			for(String tmp="";itr.hasNext();){
				tmp=(String) itr.next();
				System.out.println(tmp);
				writer.write(tmp+"\n");
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
