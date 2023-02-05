package com.study.effectivejava.common.model;

public class Reserve {

    private ReserveStatus reserveStatus;

    private static final Reserve RESERVE_COMPLETE = new Reserve(ReserveStatus.COMPLETE);
    private static final Reserve RESERVE_CANCEL = new Reserve(ReserveStatus.CANCEL);

    private Reserve(ReserveStatus reserveStatus) {
        this.reserveStatus = reserveStatus;
    }

    public static Reserve getInstance(ReserveStatus reserveStatus) {
        return new Reserve(reserveStatus);
    }

    public static Reserve statusOf(ReserveStatus reserveStatus) {
        if(ReserveStatus.COMPLETE == reserveStatus) return RESERVE_COMPLETE;
        if(ReserveStatus.CANCEL == reserveStatus) return RESERVE_CANCEL;
        return new Reserve(reserveStatus);
    }

    public ReserveStatus getReserveStatus(){
        return this.reserveStatus;
    }

}
