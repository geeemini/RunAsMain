package com.company.adapter;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2019/12/5 14:56
 * 有内鬼，中止交易
 */
public class AdapterDemo {

    public static void main(String[] args) {

        Phone phone = new Phone();
        VoltageAdapter adapter = new VoltageAdapter();
        phone.setAdapter(adapter);
        phone.charge();
    }






    static class Phone{
        public static final int V = 220;

        private VoltageAdapter adapter;

        // 充电
        public void charge() {
            adapter.changeVoltage();
        }

        public void setAdapter(VoltageAdapter adapter) {
            this.adapter = adapter;
        }

    }


    static class VoltageAdapter{
        public void changeVoltage(){
            System.out.println("正在充电...");
            System.out.println("原始电压：" + Phone.V + "V");
            System.out.println("经过变压器转换之后的电压:" + (Phone.V - 200) + "V");
        }
    }
}
