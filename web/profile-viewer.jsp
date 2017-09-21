<%--Esta vista no carga el layout. Este es el resultado final.--%>
<%@page import="model.LanguageLevel"%>
<%@page import="model.LanguageSkill"%>
<%@page import="model.OtherInfoItem"%>
<%@page import="model.Education"%>
<%@page import="java.util.List"%>
<%@page import="model.Experience"%>
<%@page import="helpers.FormatUtils"%>
<%@page import="model.Personal"%>
<%@page import="model.User"%>
<%@page import="helpers.RequestUtils"%>
<%@page import="config.Config"%>
<%
    User user = RequestUtils.getSessionUser(request);
    int user_id = user.getId();
    Personal personal = user.getPersonal();
    List<LanguageSkill> languages = LanguageSkill.findBy("user_id", String.valueOf(user_id));
    List<Experience> experiences = Experience.findBy("user_id", String.valueOf(user_id));
    List<Education> educations = Education.findBy("user_id", String.valueOf(user_id));
    List<OtherInfoItem> otherinfos = OtherInfoItem.findBy("user_id", String.valueOf(user_id));

    int picPosition = 2;

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html lang="<%=Config.LANGUAGE%>">
    <head>
        <title>Curriculum vitae</title>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />

        <meta name="keywords" content="" />
        <meta name="description" content="" />

        <link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.7.0/build/reset-fonts-grids/reset-fonts-grids.css" media="all" /> 


        <style>

            body { 
                font-family: Georgia;
                color: #444; 
            }
            #inner {
                padding: 10px 80px;
                margin: 80px auto;
                background: #f5f5f5;
                border: solid #666;
                border-width: 8px 0 2px 0; 
            }
            .yui-gf {
                margin-bottom: 2em; 
                padding-bottom: 2em;
                border-bottom: 1px solid #ccc; 
            }

            #hd {
                margin: 2.5em 0 3em 0;
                padding-bottom: 1.5em;
                border-bottom: 1px solid #ccc
            }

            #hd h2 {
                text-transform: uppercase;
                letter-spacing: 2px; 
            }

            #bd, #ft { 
                margin-bottom: 2em; 
            }

            /* //-- footer -- */
            #ft {
                padding: 1em 0 5em 0;
                font-size: 92%;
                border-top: 1px solid #ccc;
                text-align: center; 
            }

            #ft p { 
                margin-bottom: 0; text-align: center; 
            }

            /* //-- core typography and style -- */
            #hd h1 {
                font-size: 48px;
                text-transform: uppercase; 
                letter-spacing: 3px;
            }

            h2 {
                font-size: 132%;
                font-weight: bold;
            }

            titulo {
                font-size: 108%;
                font-weight: bold;               
            }

            info {
                font-size: 100%;
            }


            h3, h4 { font-size: 122%; }
            h1, h2, h3, h4 { color: #333; }
            p { font-size: 100%; line-height: 18px; padding-right: 3em; }
            a { color: #990003 }
            a:hover { text-decoration: none; }
            strong { font-weight: bold; }
            p.enlarge { font-size: 144%; padding-right: 6.5em; line-height: 24px; }
            p.enlarge span { color: #000 }
            .contact-info { margin-top: 7px; }
            .first h2 { font-style: italic; }
            .last { border-bottom: 0 }




            .job { position: relative; margin-bottom: 1em; padding-bottom: 1em; border-bottom: 1px solid #ccc; }
            .job h4 { position: absolute; top: 0.35em; right: 0 }
            .job p { margin: 0.75em 0 3em 0; }

            /* --// override to force 1/8th width grids -- */
            .yui-gf .yui-u{width:80.2%;}
            .yui-gf div.first{width:12.3%;}


            img{
                width: 190px;
                height: 200px;
            }


        </style>
    </head>
    <body>

        <div id="doc2" class="yui-t7">
            <div id="inner">

                <div id="hd">
                    <div class="yui-gc">
                        
                        <% if(picPosition == 1){%>
                        <div class="yui-u first">
                            <div class="contact-info">
                                <img title="La foto es de muestra, de momento la app no maneja bien las fotos :(" src="http://lorempixel.com/output/people-q-c-500-500-9.jpg">

                            </div>
                        </div>
                        <%}%>
                        
                        <div class="yui-u <%if(picPosition == 2){%>first<%}%>">
                            <h1><%=personal.getFullName()%></h1>
                            <h2 title="Aquí iría la marca personal del perfil, pero estamos trabajando en ello..."> Perfil estándar</h2>
                        </div>

                        <%if(picPosition == 2){%>
                        <div class="yui-u">
                            <div class="contact-info">
                                <img title="La foto es de muestra, de momento la app no maneja bien las fotos :(" src="http://www.slainte21.com/wp-content/uploads/2013/10/DSC_2525web-e1476052277449.jpg">

                            </div>
                        </div>
                        <%}%>
                    </div>
                </div>

                <div id="bd">
                    <div id="yui-main">
                        <div class="yui-b">

                            <div class="yui-gf">
                                <div class="yui-u first">
                                    <h2>DATOS PERSONALES</h2>
                                </div>
                                <div class="yui-u">
                                    <p class="enlarge">
                                        <titulo>  Residente en: </titulo> <info><%=personal.getLocation().getCity()%> (<%=personal.getLocation().getCountry().getName()%>)</info><br>
                                        <titulo>  Fecha de nacimiento: </titulo> <info> <%=FormatUtils.formatDateDayMonthYear(personal.getBirthdate())%></info><br>
                                        <titulo>  Correo electrónico:</titulo> <info> <%=user.getEmail()%></info> <br>
                                        <titulo>  Telefono: </titulo><info> <%=personal.getTelephone1()%> <%if(personal.getTelephone2() != null){%>- <%=personal.getTelephone2()%><%}%></info><br>
                                    </p>
                                </div>
                            </div>
                            
                                    
                            <%if(!languages.isEmpty()){%>
                            <div class="yui-gf">
                                <div class="yui-u first">
                                    <h2>IDIOMAS</h2>
                                </div>
                                <div class="yui-u">
                                    <p class="enlarge">
                                        <info>
                                            <%for(LanguageSkill ls : languages){%>
                                            <titulo><%=ls.getLanguage().getName()%>:</titulo>  Nivel <%=LanguageLevel.findById(ls.getLevel()).getName()%><br>
                                            <%}%>
                                        </info>
                                    </p>
                                </div>
                            </div>
                             <%}%>
                            
                            <%if(!educations.isEmpty()){%>
                            <div class="yui-gf">
                                <div class="yui-u first">
                                    <h2>FORMACIÓN</h2>
                                </div>
                                <div class="yui-u">
                                    <p class="enlarge">
                                        <info>
                                            <%for(Education e : educations){%>
                                            <titulo><%=e.getLevel().getName()%>: <%=e.getTitlename()%></titulo><br>
                                                <%=e.getCenter()%> (<%=e.getLocation().getCity()%>, <%=e.getLocation().getCountry().getName()%>) <%=FormatUtils.formatDateYear(e.getStartdate())%> - <%=FormatUtils.formatDateYear(e.getEnddate())%><br>
                                            <%}%>
                                        </info>
                                    <p>
                                </div>
                            </div>
                            <%}%>
                            
                            <%if(!experiences.isEmpty()){%>
                            <div class="yui-gf">
                                <div class="yui-u first">
                                    <h2>EXPERIENCIA PROFESIONAL</h2>
                                </div>

                                <div class="yui-u">
                                    <%for(Experience e : experiences){%>
                                    <div class="job">
                                        <h2><%=e.getJob()%></h2>
                                        <h3><%=e.getEnterprise()%></h3>
                                        <h4><%=FormatUtils.formatDateYear(e.getStartdate())%> - <%=FormatUtils.formatDateYear(e.getEnddate())%></h4>
                                        <p><%=e.getDescription()%></p>
                                    </div>
                                    <%}%>
                                    
                                </div>
                            </div>
                            <%}%>
                            
                            <%if(!otherinfos.isEmpty()){%>
                            <div class="yui-gf">
                                <div class="yui-u first">
                                    <h2>OTROS DATOS DE INTERÉS</h2>
                                </div>
                                <div class="yui-u">
                                    <p class="enlarge">
                                        <info>
                                            <%for(OtherInfoItem o : otherinfos){%>
                                            <titulo><%=o.getTitle()%><br/></titulo>  <%=o.getDescription()%><br>
                                            <%}%>
                                        </info>
                                    </p>
                                </div>
                            </div>
                            <%}%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>