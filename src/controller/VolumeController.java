package controller;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;

public class VolumeController {
	public void volumeDownControl(Double valueToPlusMinus){
		//Recuperer le mixer info par l'audio system;
		Mixer.Info[] mixers = AudioSystem.getMixerInfo();
		
		for(Mixer.Info mixerInfo : mixers){
			//recuperation du mixer
			Mixer mixer = AudioSystem.getMixer(mixerInfo);
			Line.Info[] lineInfos = mixer.getTargetLineInfo();
			for(Line.Info lineInfo : lineInfos){
				Line line = null;
				boolean opened = true;
				
				try{
					line = mixer.getLine(lineInfo);	
					opened = line.isOpen() || line instanceof Clip;
					if(!opened){
						line.open();
					}
					
					FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
					float currentVolume = volControl.getValue();
					Double volumeToCut = valueToPlusMinus;
					float changedCalc = (float) ((float)currentVolume-(double)volumeToCut);
					volControl.setValue(changedCalc);
					
				}catch(LineUnavailableException lineException){
					
				}catch (IllegalArgumentException illException) {
					
				}finally{
					if(line != null &&  !opened){
						line.close();
					}
				}
			}
			
		}
	}
	 public void volumeUpControl(Double valueToPlusMinus){
			//Recuperer le mixer info par l'audio system;
			Mixer.Info[] mixers = AudioSystem.getMixerInfo();
			
			for(Mixer.Info mixerInfo : mixers){
				//recuperation du mixer
				Mixer mixer = AudioSystem.getMixer(mixerInfo);
				Line.Info[] lineInfos = mixer.getTargetLineInfo();
				for(Line.Info lineInfo : lineInfos){
					Line line = null;
					boolean opened = true;
					
					try{
						line = mixer.getLine(lineInfo);	
						opened = line.isOpen() || line instanceof Clip;
						if(!opened){
							line.open();
						}
						
						FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
						float currentVolume = volControl.getValue();
						Double volumeToCut = valueToPlusMinus;
						float changedCalc = (float) ((float)currentVolume+(double)volumeToCut);
						volControl.setValue(changedCalc);
						
					}catch(LineUnavailableException lineException){
						
					}catch (IllegalArgumentException illException) {
						
					}finally{
						if(line != null &&  !opened){
							line.close();
						}
					}
				}
				
			}
		}
	 

	    public void volumeControl(Double valueToPlusMinus){
			//Recuperer le mixer info par l'audio system;
			Mixer.Info[] mixers = AudioSystem.getMixerInfo();
			
			for(Mixer.Info mixerInfo : mixers){
				//recuperation du mixer
				Mixer mixer = AudioSystem.getMixer(mixerInfo);
				Line.Info[] lineInfos = mixer.getTargetLineInfo();
				for(Line.Info lineInfo : lineInfos){
					Line line = null;
					boolean opened = true;
					
					try{
						line = mixer.getLine(lineInfo);	
						opened = line.isOpen() || line instanceof Clip;
						if(!opened){
							line.open();
						}
						
						FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
						float currentVolume = volControl.getValue();
						Double volumeToCut = valueToPlusMinus;
						float changedCalc = (float) ((double)volumeToCut);
						volControl.setValue(changedCalc);
						
					}catch(LineUnavailableException lineException){
						
					}catch (IllegalArgumentException illException) {
						
					}finally{
						if(line != null &&  !opened){
							line.close();
						}
					}
				}
				
			}
		}


}
