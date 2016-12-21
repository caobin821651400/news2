package news.example.cb.com.news.http;

import java.io.Serializable;
import java.util.List;

/**
 * Created by caobin on 2016/12/20.
 */
public class NbaResp implements Serializable{
    private static final long serialVersionUID = -1548328265816816207L;

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {


        private String title;
        private StatuslistBean statuslist;
        private List<ListBean> list;
        private List<TeammatchBean> teammatch;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public StatuslistBean getStatuslist() {
            return statuslist;
        }

        public void setStatuslist(StatuslistBean statuslist) {
            this.statuslist = statuslist;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public List<TeammatchBean> getTeammatch() {
            return teammatch;
        }

        public void setTeammatch(List<TeammatchBean> teammatch) {
            this.teammatch = teammatch;
        }

        public static class StatuslistBean {
            /**
             * st0 : 未开赛
             * st1 : 直播中
             * st2 : 已结束
             */

            private String st0;
            private String st1;
            private String st2;

            public String getSt0() {
                return st0;
            }

            public void setSt0(String st0) {
                this.st0 = st0;
            }

            public String getSt1() {
                return st1;
            }

            public void setSt1(String st1) {
                this.st1 = st1;
            }

            public String getSt2() {
                return st2;
            }

            public void setSt2(String st2) {
                this.st2 = st2;
            }
        }

        public static class ListBean {
            /**
             * title : 12-19 周一
             * tr : [{"time":"12/19 04:30","player1":"快船","player2":"奇才","player1logo":"http://p0.qhmsg.com/t01ac22731d284b6005.png?size=78x78","player2logo":"http://p4.qhmsg.com/t010558d60306395e77.png?size=78x78","player1logobig":"http://p6.qhmsg.com/t01ac22731d284b6005.png?size=78x78","player2logobig":"http://p1.qhmsg.com/t010558d60306395e77.png?size=78x78","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=12","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=27","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1469459","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1469459%26title%3D%25E5%25BF%25AB%25E8%2588%25B9VS%25E5%25A5%2587%25E6%2589%258D%26ptag%3D360.onebox.schedule.nba&m=3f4209&from=juhe&type=nba_new&juid=JH69e4013ec11edc693be6139eb5dbfbaf","link2text":"技术统计","link2url":"http://nba.stats.qq.com/nbascore/?mid=1469459","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1469459%26title%3D%25E5%25BF%25AB%25E8%2588%25B9VS%25E5%25A5%2587%25E6%2589%258D%26ptag%3D360.onebox.schedule.nba&m=3f4209&from=juhe&type=nba_new&juid=JH69e4013ec11edc693be6139eb5dbfbaf","status":2,"score":"110-117","link1text":"视频集锦"},{"time":"12/19 05:00","player1":"国王","player2":"小牛","player1logo":"http://p2.qhmsg.com/t0179411022c3587ba2.png?size=78x78","player2logo":"http://p7.qhmsg.com/t016809e551c18d1ad5.png?size=78x78","player1logobig":"http://p5.qhmsg.com/t0179411022c3587ba2.png?size=78x78","player2logobig":"http://p0.qhmsg.com/t016809e551c18d1ad5.png?size=78x78","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=23","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=6","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1469464","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1469464%26title%3D%25E5%259B%25BD%25E7%258E%258BVS%25E5%25B0%258F%25E7%2589%259B%26ptag%3D360.onebox.schedule.nba&m=96da6a&from=juhe&type=nba_new&juid=JH69e4013ec11edc693be6139eb5dbfbaf","link2text":"技术统计","link2url":"http://nba.stats.qq.com/nbascore/?mid=1469464","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1469464%26title%3D%25E5%259B%25BD%25E7%258E%258BVS%25E5%25B0%258F%25E7%2589%259B%26ptag%3D360.onebox.schedule.nba&m=96da6a&from=juhe&type=nba_new&juid=JH69e4013ec11edc693be6139eb5dbfbaf","status":2,"score":"79-99","link1text":"视频集锦"},{"time":"12/19 07:00","player1":"爵士","player2":"灰熊","player1logo":"http://p9.qhmsg.com/t01fd6c067295c676d3.png?size=78x78","player2logo":"http://p8.qhmsg.com/t01c6cd06b91021cabb.png?size=78x78","player1logobig":"http://p4.qhmsg.com/t01fd6c067295c676d3.png?size=78x78","player2logobig":"http://p4.qhmsg.com/t01c6cd06b91021cabb.png?size=78x78","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=26","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=29","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1469460","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1469460%26title%3D%25E7%2588%25B5%25E5%25A3%25ABVS%25E7%2581%25B0%25E7%2586%258A%26ptag%3D360.onebox.schedule.nba&m=02d7b9&from=juhe&type=nba_new&juid=JH69e4013ec11edc693be6139eb5dbfbaf","link2text":"技术统计","link2url":"http://nba.stats.qq.com/nbascore/?mid=1469460","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1469460%26title%3D%25E7%2588%25B5%25E5%25A3%25ABVS%25E7%2581%25B0%25E7%2586%258A%26ptag%3D360.onebox.schedule.nba&m=02d7b9&from=juhe&type=nba_new&juid=JH69e4013ec11edc693be6139eb5dbfbaf","status":2,"score":"82-73","link1text":"视频集锦"},{"time":"12/19 07:00","player1":"篮网","player2":"76人","player1logo":"http://p0.qhmsg.com/t01642d73a8ebb2f3b6.png?size=78x78","player2logo":"http://p9.qhmsg.com/t01ca447da8c1f1be3f.png?size=78x78","player1logobig":"http://p2.qhmsg.com/t01642d73a8ebb2f3b6.png?size=78x78","player2logobig":"http://p6.qhmsg.com/t01ca447da8c1f1be3f.png?size=78x78","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=17","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=20","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1469461","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1469461%26title%3D%25E7%25AF%25AE%25E7%25BD%2591VS76%25E4%25BA%25BA%26ptag%3D360.onebox.schedule.nba&m=8b952d&from=juhe&type=nba_new&juid=JH69e4013ec11edc693be6139eb5dbfbaf","link2text":"技术统计","link2url":"http://nba.stats.qq.com/nbascore/?mid=1469461","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1469461%26title%3D%25E7%25AF%25AE%25E7%25BD%2591VS76%25E4%25BA%25BA%26ptag%3D360.onebox.schedule.nba&m=8b952d&from=juhe&type=nba_new&juid=JH69e4013ec11edc693be6139eb5dbfbaf","status":2,"score":"107-108","link1text":"视频集锦"},{"time":"12/19 07:00","player1":"猛龙","player2":"魔术","player1logo":"http://p2.qhmsg.com/t0126c995f7a0e28ef3.png?size=78x78","player2logo":"http://p9.qhmsg.com/t015a91103bd3713d72.png?size=78x78","player1logobig":"http://p3.qhmsg.com/t0126c995f7a0e28ef3.png?size=78x78","player2logobig":"http://p8.qhmsg.com/t015a91103bd3713d72.png?size=78x78","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=28","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=19","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1469462","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1469462%26title%3D%25E7%258C%259B%25E9%25BE%2599VS%25E9%25AD%2594%25E6%259C%25AF%26ptag%3D360.onebox.schedule.nba&m=0d9c44&from=juhe&type=nba_new&juid=JH69e4013ec11edc693be6139eb5dbfbaf","link2text":"技术统计","link2url":"http://nba.stats.qq.com/nbascore/?mid=1469462","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1469462%26title%3D%25E7%258C%259B%25E9%25BE%2599VS%25E9%25AD%2594%25E6%259C%25AF%26ptag%3D360.onebox.schedule.nba&m=0d9c44&from=juhe&type=nba_new&juid=JH69e4013ec11edc693be6139eb5dbfbaf","status":2,"score":"109-79","link1text":"视频集锦"},{"time":"12/19 07:00","player1":"凯尔特人","player2":"热火","player1logo":"http://p7.qhmsg.com/t019f61e3222cd24332.png?size=78x78","player2logo":"http://p5.qhmsg.com/t011bd398c0da29c27d.png?size=78x78","player1logobig":"http://p8.qhmsg.com/t019f61e3222cd24332.png?size=78x78","player2logobig":"http://p9.qhmsg.com/t011bd398c0da29c27d.png?size=78x78","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=2","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=14","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1469463","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1469463%26title%3D%25E5%2587%25AF%25E5%25B0%2594%25E7%2589%25B9%25E4%25BA%25BAVS%25E7%2583%25AD%25E7%2581%25AB%26ptag%3D360.onebox.schedule.nba&m=c00242&from=juhe&type=nba_new&juid=JH69e4013ec11edc693be6139eb5dbfbaf","link2text":"技术统计","link2url":"http://nba.stats.qq.com/nbascore/?mid=1469463","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1469463%26title%3D%25E5%2587%25AF%25E5%25B0%2594%25E7%2589%25B9%25E4%25BA%25BAVS%25E7%2583%25AD%25E7%2581%25AB%26ptag%3D360.onebox.schedule.nba&m=c00242&from=juhe&type=nba_new&juid=JH69e4013ec11edc693be6139eb5dbfbaf","status":2,"score":"105-95","link1text":"视频集锦"},{"time":"12/19 08:00","player1":"鹈鹕","player2":"马刺","player1logo":"http://p3.qhmsg.com/t010415e17c8ec18459.png?size=78x78","player2logo":"http://p3.qhmsg.com/t01865a1ad0b0987285.png?size=78x78","player1logobig":"http://p8.qhmsg.com/t010415e17c8ec18459.png?size=78x78","player2logobig":"http://p6.qhmsg.com/t01865a1ad0b0987285.png?size=78x78","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=3","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=24","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1469465","m_link1url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1469465%26title%3D%25E9%25B9%2588%25E9%25B9%2595VS%25E9%25A9%25AC%25E5%2588%25BA%26ptag%3D360.onebox.schedule.nba&m=9f0d41&from=juhe&type=nba_new&juid=JH69e4013ec11edc693be6139eb5dbfbaf","link2text":"技术统计","link2url":"http://nba.stats.qq.com/nbascore/?mid=1469465","m_link2url":"http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1469465%26title%3D%25E9%25B9%2588%25E9%25B9%2595VS%25E9%25A9%25AC%25E5%2588%25BA%26ptag%3D360.onebox.schedule.nba&m=9f0d41&from=juhe&type=nba_new&juid=JH69e4013ec11edc693be6139eb5dbfbaf","status":2,"score":"100-113","link1text":"视频集锦"}]
             * bottomlink : [{"text":"常规赛赛程","url":"http://sports.qq.com/nba/schedule/?ptag=360.onebox.schedule.nba"},{"text":"球队排名","url":"http://sports.qq.com/nba/standings/?ptag=360.onebox.schedule.nba"},{"text":"球员排名","url":"http://nba.stats.qq.com/stats/?ptag=360.onebox.schedule.nba"},{"text":"社区讨论","url":"http://sports.qq.com/fans/group.htm?mid=69"}]
             * live : [{"title":"10:00开赛 比赛结束","player1":"小牛","player2":"掘金","player1info":"胜7负21西部15名","player2info":"胜12负16西部9名","player1logobig":"http://p0.qhmsg.com/t016809e551c18d1ad5.png?size=78x78","player2logobig":"http://p1.qhmsg.com/t01c366fdb3044d96db.png?size=78x78","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=6","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=7","player1location":"(客)","player2location":"(主)","status":2,"score":"107-117","liveurl":""}]
             * livelink : [{"text":"视频集锦","url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1469470"},{"text":"技术统计","url":"http://nba.stats.qq.com/nbascore/?mid=1469470"}]
             */

            private String title;
            private List<TrBean> tr;
            private List<BottomlinkBean> bottomlink;
            private List<LiveBean> live;
            private List<LivelinkBean> livelink;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<TrBean> getTr() {
                return tr;
            }

            public void setTr(List<TrBean> tr) {
                this.tr = tr;
            }

            public List<BottomlinkBean> getBottomlink() {
                return bottomlink;
            }

            public void setBottomlink(List<BottomlinkBean> bottomlink) {
                this.bottomlink = bottomlink;
            }

            public List<LiveBean> getLive() {
                return live;
            }

            public void setLive(List<LiveBean> live) {
                this.live = live;
            }

            public List<LivelinkBean> getLivelink() {
                return livelink;
            }

            public void setLivelink(List<LivelinkBean> livelink) {
                this.livelink = livelink;
            }

            public static class TrBean {
                /**
                 * time : 12/19 04:30
                 * player1 : 快船
                 * player2 : 奇才
                 * player1logo : http://p0.qhmsg.com/t01ac22731d284b6005.png?size=78x78
                 * player2logo : http://p4.qhmsg.com/t010558d60306395e77.png?size=78x78
                 * player1logobig : http://p6.qhmsg.com/t01ac22731d284b6005.png?size=78x78
                 * player2logobig : http://p1.qhmsg.com/t010558d60306395e77.png?size=78x78
                 * player1url : http://kbs.sports.qq.com/kbsweb/teams.htm?tid=12
                 * player2url : http://kbs.sports.qq.com/kbsweb/teams.htm?tid=27
                 * link1url : http://sports.qq.com/kbsweb/game.htm?mid=100000:1469459
                 * m_link1url : http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1469459%26title%3D%25E5%25BF%25AB%25E8%2588%25B9VS%25E5%25A5%2587%25E6%2589%258D%26ptag%3D360.onebox.schedule.nba&m=3f4209&from=juhe&type=nba_new&juid=JH69e4013ec11edc693be6139eb5dbfbaf
                 * link2text : 技术统计
                 * link2url : http://nba.stats.qq.com/nbascore/?mid=1469459
                 * m_link2url : http://j.www.haosou.com/?u=http%3A%2F%2Fsports.qq.com%2Fkbsweb%2Fkbsshare%2Fgame.htm%3Fmid%3D100000%3A1469459%26title%3D%25E5%25BF%25AB%25E8%2588%25B9VS%25E5%25A5%2587%25E6%2589%258D%26ptag%3D360.onebox.schedule.nba&m=3f4209&from=juhe&type=nba_new&juid=JH69e4013ec11edc693be6139eb5dbfbaf
                 * status : 2
                 * score : 110-117
                 * link1text : 视频集锦
                 */

                private String time;
                private String player1;
                private String player2;
                private String player1logo;
                private String player2logo;
                private String player1logobig;
                private String player2logobig;
                private String player1url;
                private String player2url;
                private String link1url;
                private String m_link1url;
                private String link2text;
                private String link2url;
                private String m_link2url;
                private int status;
                private String score;
                private String link1text;

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }

                public String getPlayer1() {
                    return player1;
                }

                public void setPlayer1(String player1) {
                    this.player1 = player1;
                }

                public String getPlayer2() {
                    return player2;
                }

                public void setPlayer2(String player2) {
                    this.player2 = player2;
                }

                public String getPlayer1logo() {
                    return player1logo;
                }

                public void setPlayer1logo(String player1logo) {
                    this.player1logo = player1logo;
                }

                public String getPlayer2logo() {
                    return player2logo;
                }

                public void setPlayer2logo(String player2logo) {
                    this.player2logo = player2logo;
                }

                public String getPlayer1logobig() {
                    return player1logobig;
                }

                public void setPlayer1logobig(String player1logobig) {
                    this.player1logobig = player1logobig;
                }

                public String getPlayer2logobig() {
                    return player2logobig;
                }

                public void setPlayer2logobig(String player2logobig) {
                    this.player2logobig = player2logobig;
                }

                public String getPlayer1url() {
                    return player1url;
                }

                public void setPlayer1url(String player1url) {
                    this.player1url = player1url;
                }

                public String getPlayer2url() {
                    return player2url;
                }

                public void setPlayer2url(String player2url) {
                    this.player2url = player2url;
                }

                public String getLink1url() {
                    return link1url;
                }

                public void setLink1url(String link1url) {
                    this.link1url = link1url;
                }

                public String getM_link1url() {
                    return m_link1url;
                }

                public void setM_link1url(String m_link1url) {
                    this.m_link1url = m_link1url;
                }

                public String getLink2text() {
                    return link2text;
                }

                public void setLink2text(String link2text) {
                    this.link2text = link2text;
                }

                public String getLink2url() {
                    return link2url;
                }

                public void setLink2url(String link2url) {
                    this.link2url = link2url;
                }

                public String getM_link2url() {
                    return m_link2url;
                }

                public void setM_link2url(String m_link2url) {
                    this.m_link2url = m_link2url;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getScore() {
                    return score;
                }

                public void setScore(String score) {
                    this.score = score;
                }

                public String getLink1text() {
                    return link1text;
                }

                public void setLink1text(String link1text) {
                    this.link1text = link1text;
                }
            }

            public static class BottomlinkBean {
                /**
                 * text : 常规赛赛程
                 * url : http://sports.qq.com/nba/schedule/?ptag=360.onebox.schedule.nba
                 */

                private String text;
                private String url;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }

            public static class LiveBean {
                /**
                 * title : 10:00开赛 比赛结束
                 * player1 : 小牛
                 * player2 : 掘金
                 * player1info : 胜7负21西部15名
                 * player2info : 胜12负16西部9名
                 * player1logobig : http://p0.qhmsg.com/t016809e551c18d1ad5.png?size=78x78
                 * player2logobig : http://p1.qhmsg.com/t01c366fdb3044d96db.png?size=78x78
                 * player1url : http://kbs.sports.qq.com/kbsweb/teams.htm?tid=6
                 * player2url : http://kbs.sports.qq.com/kbsweb/teams.htm?tid=7
                 * player1location : (客)
                 * player2location : (主)
                 * status : 2
                 * score : 107-117
                 * liveurl :
                 */

                private String title;
                private String player1;
                private String player2;
                private String player1info;
                private String player2info;
                private String player1logobig;
                private String player2logobig;
                private String player1url;
                private String player2url;
                private String player1location;
                private String player2location;
                private int status;
                private String score;
                private String liveurl;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getPlayer1() {
                    return player1;
                }

                public void setPlayer1(String player1) {
                    this.player1 = player1;
                }

                public String getPlayer2() {
                    return player2;
                }

                public void setPlayer2(String player2) {
                    this.player2 = player2;
                }

                public String getPlayer1info() {
                    return player1info;
                }

                public void setPlayer1info(String player1info) {
                    this.player1info = player1info;
                }

                public String getPlayer2info() {
                    return player2info;
                }

                public void setPlayer2info(String player2info) {
                    this.player2info = player2info;
                }

                public String getPlayer1logobig() {
                    return player1logobig;
                }

                public void setPlayer1logobig(String player1logobig) {
                    this.player1logobig = player1logobig;
                }

                public String getPlayer2logobig() {
                    return player2logobig;
                }

                public void setPlayer2logobig(String player2logobig) {
                    this.player2logobig = player2logobig;
                }

                public String getPlayer1url() {
                    return player1url;
                }

                public void setPlayer1url(String player1url) {
                    this.player1url = player1url;
                }

                public String getPlayer2url() {
                    return player2url;
                }

                public void setPlayer2url(String player2url) {
                    this.player2url = player2url;
                }

                public String getPlayer1location() {
                    return player1location;
                }

                public void setPlayer1location(String player1location) {
                    this.player1location = player1location;
                }

                public String getPlayer2location() {
                    return player2location;
                }

                public void setPlayer2location(String player2location) {
                    this.player2location = player2location;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getScore() {
                    return score;
                }

                public void setScore(String score) {
                    this.score = score;
                }

                public String getLiveurl() {
                    return liveurl;
                }

                public void setLiveurl(String liveurl) {
                    this.liveurl = liveurl;
                }
            }

            public static class LivelinkBean {
                /**
                 * text : 视频集锦
                 * url : http://sports.qq.com/kbsweb/game.htm?mid=100000:1469470
                 */

                private String text;
                private String url;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }

        public static class TeammatchBean {
            /**
             * name : 老鹰
             * url : http://sports.qq.com/nba/schedule/?team=hawks
             */

            private String name;
            private String url;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
