package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "articles", schema = "congresso", catalog = "")
public class ArticlesEntity {
    private String title;
    private String pdf;
    private String id;
    private String resume;

    @Basic
    @Column(name = "title", nullable = true, length = 10)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "pdf", nullable = true, length = 10)
    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    @Id
    @Column(name = "id", nullable = false, length = 10)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "resume", nullable = true, length = -1)
    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticlesEntity that = (ArticlesEntity) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(pdf, that.pdf) &&
                Objects.equals(id, that.id) &&
                Objects.equals(resume, that.resume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, pdf, id, resume);
    }
}
