package config;

import java.util.HashMap;

/**
 * Un diccionario guarda los diferentes conceptos usados por la aplicación (entradas) y su equivalencia en
 * varios idiomas. 
 * 
 * Al buscar una entrada, puedes obtener su equivalencia en varios idiomas.
 * 
 * El diccionario usa el patrón singleton (una sola instancia por aplicación) y no se inicializa hasta
 * su primer uso.
 * 
 * El diccionario tiene previsto usarse principalmente para conceptos relacionados con la interfaz de la aplicación,
 * y no con su contenido (el cual se obtiene de sus respectivas tablas de la base de datos).
 * 
 * @author David
 */
public class Dictionary
{
    private static Dictionary instance;
    
    /**
     * Esta clase usa el patrón singleton, así que no es instanciable desde fuera.
     * Utiliza getInstance para obtener su instancia.
     */
    private Dictionary(){}
    
    
    private final HashMap<String, DictionaryEntry> entries = new HashMap<>();
    
    /**
     * Obtiene el valor de una entrada de la aplicación, en el idioma que dicha aplicación esté configurada.
     * @param key
     * @return 
     */
    public String get(String key)
    {
        return this.getEntries().get(key).get(Config.LANGUAGE);
    }
    
    /**
     * Obtiene un mapa del diccionario.
     * @return 
     */
    protected HashMap<String, DictionaryEntry> getEntries()
    {
        return this.entries;
    }
    
    /**
     * Agrega una nueva entrada al diccionario, a partir de la clave de acceso y las equivalencias en diversos idiomas.
     * @param key
     * @param es
     * @param ca
     * @param en 
     */
    public void newEntry(String key, String es, String ca, String en)
    {
        this.getEntries().put(key, new DictionaryEntry(es, ca, en));
    }

    /**
     * Obtiene la instancia única de diccionario de la aplicación.
     * 
     * Si no se ha definido antes, se definirá al llamarse a este método por primera vez.
     * @return 
     */
    public static Dictionary getInstance()
    {
        if(instance == null)
        {
            instance = new Dictionary();
            
            instance.newEntry("example", 
                    "ejemplo", 
                    "exemple", 
                    "example");
            instance.newEntry("login", 
                    "Iniciar sesión", 
                    "Iniciar sessió", 
                    "Login");
            instance.newEntry("register", 
                    "Registrarse", 
                    "Enregistrar-se", 
                    "Register");
            instance.newEntry("logout", 
                    "Cerrar sesión", 
                    "Tanca sessió", 
                    "Logout");
            instance.newEntry("email-form-label", 
                    "Correo electrónico", 
                    "Correu electrònic", 
                    "E-Mail");
            instance.newEntry("password-form-label", 
                    "Contraseña", 
                    "Clau de pas", 
                    "Password");
            instance.newEntry("name-form-label", 
                    "Nombre", 
                    "Nom", 
                    "Name");
            instance.newEntry("lastname-form-label", 
                    "Apellido(s)", 
                    "Cognom(s)", 
                    "Last Name");
            instance.newEntry("gender-form-label", 
                    "Género", 
                    "Gènere", 
                    "Gender");
            instance.newEntry("birthdate-form-label", 
                    "Fecha de Nacimiento", 
                    "Data de Naixement", 
                    "Birthdate");
            instance.newEntry("country-form-label", 
                    "País", 
                    "Païs", 
                    "Country");
            instance.newEntry("province-form-label", 
                    "Provincia", 
                    "Província", 
                    "Province");
            instance.newEntry("city-form-label", 
                    "Ciudad/Población", 
                    "Ciutat/Població", 
                    "City");
            instance.newEntry("telephone-form-label", 
                    "Teléfono", 
                    "Telèfon", 
                    "Telephone");
            instance.newEntry("description-form-label", 
                    "Descripción", 
                    "Descripció", 
                    "Description");
            instance.newEntry("personal-section-title", 
                    "Información Personal",
                    "Informació Personal", 
                    "Personal Information");
            instance.newEntry("experience-section-title", 
                    "Experiencia Laboral", 
                    "Experiència Laboral", 
                    "Working Experience");
            instance.newEntry("education-section-title", 
                    "Educación y formación", 
                    "Educació i formació", 
                    "Education and Training");
            instance.newEntry("education-add-new-description", 
                    "Añade una nueva educación o formación", 
                    "Afegeix una nova educació o formació", 
                    "Insert a new Education and Training");
            instance.newEntry("languages-section-title", 
                    "Idiomas", 
                    "Idiomes", 
                    "Languages");
            instance.newEntry("otherinfo-section-title", 
                    "Otra información", 
                    "Altra informació", 
                    "Other Information");
            instance.newEntry("otherinfo-add-new-description", 
                    "Añade una nueva información de interés", 
                    "Afegeix una nova informació d'interés", 
                    "Insert a new other information");
            instance.newEntry("save", 
                    "Guardar", 
                    "Desar", 
                    "Save");
            instance.newEntry("edit", 
                    "Editar", 
                    "Editar", 
                    "Edit");
            instance.newEntry("delete", 
                    "Borrar", 
                    "Eliminar", 
                    "Delete");
            instance.newEntry("my-data", 
                    "Mis datos", 
                    "Les meves dades", 
                    "My data");
            instance.newEntry("my-data-description", 
                    "¡Introduce aquí toda tu información!", 
                    "Introdueix aquí tota la teva informació!", 
                    "Enter here your data!");
            instance.newEntry("new-profile", 
                    "Crear nuevo perfil", 
                    "Crea nou perfil", 
                    "Create new profile");
            instance.newEntry("new-profile-description", 
                    "¡Ordena, filtra y presenta tu información!", 
                    "Endreça, filtra i presenta les teves dades!", 
                    "Order, filter and display your data!");
            instance.newEntry("my-cvs", 
                    "Mis CVs", 
                    "Els meus CVs", 
                    "My CVs");
            instance.newEntry("my-evs-description", 
                    "¡Accede a tus currículums!", 
                    "Accedeix aquí als teus currículums!", 
                    "Access here to your CVs!");
            instance.newEntry("pic-position-form-label", 
                    "Posición de la fotografía", 
                    "Posició de la fotografia", 
                    "Picture position");
            instance.newEntry("tag", 
                    "Etiqueta", 
                    "Etiqueta", 
                    "Tag");
            instance.newEntry("next", 
                    "Siguiente", 
                    "Següent", 
                    "Next");
        }
        
        return instance;
    }
    
    /**
     * Obtiene la palabra correspondiente a la clave de búsqueda en el idioma de configuración de la
     * aplicación. 
     * 
     * Si no existe la clave o su equivalencia al idioma de la aplicación, devuelve null.
     * 
     * @param search
     * @return 
     */
    public static String vocab(String search)
    {
        return getInstance().get(search);
    }
    
    /**
     * Esta clase solamente es visible dentro de diccionario y sus hijos.
     * 
     * Representa las asignaciones de una entrada en diversos idiomas.
     *
     * Si se desea añadir equivalencias en más idiomas para la aplicación, se puede configurar aquí.
     */
    protected class DictionaryEntry 
    {
        String es;
        String ca;
        String en;
        
        DictionaryEntry(String es, String ca, String en)
        {
            this.es = es;
            this.ca = ca;
            this.en = en;
        }
        
        /**
         * Obtiene la asignación al idioma enviado como cadena de texto. Si no existe la asignación,
         * devuelve null.
         * @param language
         * @return 
         */
        String get(String language)
        {
            String word = null;
            
            switch(language)
            {
                case "es":
                    word = this.es;
                    break;
                case "ca":
                    word = this.ca;
                    break;
                case "en":
                    word = this.en;
                    break;
            }
            
            return word;
        }
        
    }
}
