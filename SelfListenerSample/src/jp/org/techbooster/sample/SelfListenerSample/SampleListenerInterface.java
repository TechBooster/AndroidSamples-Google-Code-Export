package jp.org.techbooster.sample.SelfListenerSample;

import java.util.EventListener;

public interface SampleListenerInterface extends EventListener {
    
    /**
     * ���������͂���Ă��Ȃ���Ԃ�ʒm����
     */
    public void noInputText();
    
    
    /**
     * ���������͂���Ă����Ԃ�ʒm����
     */
    public void inputText();
}
